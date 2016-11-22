package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.lists.LinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class CollegeRegistration implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final HashMap<String, RunnableWithException<ActionCancelledException>> options = new HashMap<>();
    private final LinkedList<Student> students = new LinkedList<>();
    private final LinkedList<Teacher> teachers = new LinkedList<>();
    private final LinkedList<Course> courses = new LinkedList<>();

    // Populate options HashMap
    {
        options.put("", () -> running.set(false));

        options.put(".s", () -> printList(students));
        options.put(".t", () -> printList(teachers));
        options.put(".c", () -> printList(courses));

        options.put("+s", this::addStudent);
        options.put("+t", this::addTeacher);
        options.put("+c", this::addCourse);
    }

    public static void main(String[] args) {
        new CollegeRegistration().run();
    }

    public void run() {
        while (running.get()) {
            System.out.println("\nPlease enter two characters - '+' to add or '.' to list, " +
                    "followed by 's' for students, 't' for teachers or 'c' for courses; enter nothing to stop.");
            try {
                options.get(inputLoop("Enter option: ", "Invalid option!", options::containsKey)).run();
            } catch (ActionCancelledException e) {
                System.out.println("Action cancelled.");
            }
        }
        System.out.println("Quitting...");
    }


    // <editor-fold desc="Addition Functions">

    private void addStudent(Student student) {
        students.add(student);
    }

    private void addStudent() {
        addStudent(new Student());
    }

    private void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    private void addTeacher() throws ActionCancelledException {
        addTeacher(new Teacher(this::inputCourse));
    }

    private void addCourse(Course course) {
        courses.add(course);
    }

    private void addCourse() {
        addCourse(new Course());
    }

    // </editor-fold>

    private static <T> void printList(LinkedList<T> ls) {
        if (ls.isEmpty()) {
            System.out.println("List is empty.");
        }
        ls.forEach(System.out::println);
    }

    // <editor-fold desc="Input Functions">

    static Department inputDepartment() {
        System.out.println("Available courses: " + Arrays.toString(Department.values()).replace("[", "".replace("]", "")));
        return Department.valueOf(inputLoop("Enter department: ", "Invalid department!",
                runsCleanly(str -> { Department.valueOf(str.toUpperCase()); })).toUpperCase());
    }

    private Course inputCourse() throws ActionCancelledException {
        Course course;
        if (courses.isEmpty()){
            System.out.println("There are no available courses!");
            if(!inputBoolLoop("Do you want to create a new course? ", true)) throw new ActionCancelledException();
            course = new Course();
            addCourse(course);
            return course;
        }
        System.out.println("Available courses...");
        printList(courses);

        final String input = inputLoop("Enter course code, or nothing to cancel: ", "Course code does not exist!",
                str -> str.equals("") || courses.stream().map(Course::getCode).anyMatch(str::equals));

        if (input.equals("")) throw new ActionCancelledException();
        return courses.firstMatch(c -> input.equals(c.getCode()));

    }

    // </editor-fold>

}

@SuppressWarnings("unused")
enum Department {
    MATHS, PHYSICS, CHEMISTRY, BIOLOGY, COMPUTING, ENGLISH, ART
}

class ActionCancelledException extends Exception {}
