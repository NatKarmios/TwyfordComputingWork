package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.lists.LinkedList;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class CollegeRegistration implements Runnable {
    private final transient AtomicBoolean running = new AtomicBoolean(true);
    private final transient HashMap<String, RunnableWithException<ActionCancelledException>> options = new HashMap<>();
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
        load().run();
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
        save();
    }

    private void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    private void addTeacher() throws ActionCancelledException {
        addTeacher(new Teacher(this::inputCourse));
        save();
    }

    private void addCourse(Course course) {
        courses.add(course);
    }

    private void addCourse() {
        addCourse(new Course(this::checkCourseCode));
        save();
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
            course = new Course(this::checkCourseCode);
            addCourse(course);
            save();
            return course;
        }
        System.out.println("Available courses...");
        printList(courses);

        final String input = inputLoop("Enter course code, or nothing to cancel: ", "Course code does not exist!",
                str -> str.equals("") || courses.stream().map(Course::getCode).anyMatch(str::equals));

        if (input.equals("")) throw new ActionCancelledException();
        return courses.firstMatch(c -> input.equals(c.getCode()));

    }

    private boolean checkCourseCode(String code) {
        return !courses.stream().map(Course::getCode).anyMatch(code::equals);
    }

    private Course getCourseFromCode(String courseCode) {
        return courses.firstMatch(course -> course.getCode().equals(courseCode));
    }
    // </editor-fold>

    private static CollegeRegistration load() {
        CollegeRegistration collegeRegistration = new CollegeRegistration();
        try (Reader reader = new FileReader(getClassDir(CollegeRegistration.class) + "college_registration.json")) {
            JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

            StreamSupport.stream(jsonObject.getAsJsonArray("students").spliterator(), false)
                    .map(JsonElement::getAsJsonObject).forEach(obj ->
                        collegeRegistration.students.add(new Student(
                                obj.get("name").getAsString(),
                                obj.get("address").getAsString(),
                                Person.Gender.valueOf(obj.get("gender").getAsString()),
                                obj.get("contactNumber").getAsString()
                        )));

            StreamSupport.stream(jsonObject.getAsJsonArray("courses").spliterator(), false)
                    .map(JsonElement::getAsJsonObject).forEach(obj ->
                    collegeRegistration.courses.add(new Course(
                            obj.get("name").getAsString(),
                            obj.get("code").getAsString(),
                            Department.valueOf(obj.get("department").getAsString())
                    )));

            StreamSupport.stream(jsonObject.getAsJsonArray("teachers").spliterator(), false)
                    .map(JsonElement::getAsJsonObject).forEach(obj ->
                    collegeRegistration.teachers.add(new Teacher(
                            obj.get("name").getAsString(),
                            obj.get("address").getAsString(),
                            Person.Gender.valueOf(obj.get("gender").getAsString()),
                            Department.valueOf(obj.get("department").getAsString()),
                            obj.get("salary").getAsFloat(),
                            obj.get("courseCode").getAsString(),
                            collegeRegistration::getCourseFromCode
                    )));
        }
        catch (IOException e) {
            System.err.println("Failed to load from file!");
        }
        return collegeRegistration;
    }

    private void save() {
        try (FileWriter writer = new FileWriter(getClassDir(this.getClass()) + "college_registration.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            System.err.println("Failed to save to file!");
        }
    }
}

@SuppressWarnings("unused")
enum Department {
    MATHS, PHYSICS, CHEMISTRY, BIOLOGY, COMPUTING, ENGLISH, ART
}

class ActionCancelledException extends Exception {}
