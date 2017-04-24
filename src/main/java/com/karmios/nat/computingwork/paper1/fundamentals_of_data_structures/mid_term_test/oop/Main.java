package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.mid_term_test.oop;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Benjamin", 17, "12T", "Computer Science");
        student2.printStudent();
        student2.printPerson();

        Teacher teacher1 = new Teacher("Mr. Bate", 30, "07984738923", "Mathematics");
        Teacher teacher2 = new Teacher();
        teacher2.printPerson();

        Course course = new Course("Computer Science", teacher1);
        course.printCourse();
    }
}
