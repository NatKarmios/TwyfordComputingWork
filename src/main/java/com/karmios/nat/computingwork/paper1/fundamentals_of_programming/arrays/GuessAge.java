package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.arrays;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class GuessAge implements Runnable{
    private int score = 0;
    private Student[] students = new Student[10];

    public static void main(String[] args) {
        new GuessAge().run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) students[i] = new Student();
        printStudents();
        for(int i=0; i<10; i++) {
            askQuestion();
        }
        System.out.println("\nFinal score: " + score + " out of 10.");
    }

    private void askQuestion() {
        shuffleStudents();

        System.out.print("Guess the age of the student in position 5: ");
        try  {
            if (inputIntLoop() != students[5].getAge())
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Wrong, the answer was " + students[5].getAge() + ".\n");
            return;
        }

        System.out.println("Correct!\n");
        score++;
    }

    private void shuffleStudents() {
        Student[] shuffled = new Student[students.length];

        int place;
        for (Student student : students) {
            //noinspection StatementWithEmptyBody
            while (shuffled[(place = rng.nextInt(students.length))] != null) ;
            shuffled[place] = student;
        }

        students = shuffled;
    }

    private void printStudents() {
        System.out.println("Current students: ");
        for (Student stu : students) {
            stu.printPerson();
        }
        System.out.println();
    }
}

abstract class Person {
    private static int numCreated = 1;


    private String nameNum;
    private int age;

    Person() {
        this(defaultName(), randAge());
    }

    private Person(String name, int age) {
        nameNum = name;
        this.age = age;

        numCreated++;
    }

    String getName() {
        return nameNum;
    }

    void setName(String name) {
        nameNum = name;
    }

    int getAge() {
        return age;
    }

    @SuppressWarnings("unused")
    void setAge(int age) {
        this.age = age;
    }

    void printPerson() {
        System.out.println(nameNum + ", " + String.valueOf(age));
    }



    static String defaultName() {
        return "John" + String.valueOf(numCreated);
    }

    static int randAge() {
        return rng.nextInt(5)+16;
    }
}


@SuppressWarnings({"WeakerAccess", "unused"})
class Student extends Person {
    String form, favouriteSubject;

    Student() {
        this(defaultName(), randAge());
    }

    Student(String name, int age) {
        this(name, age, "12W2", "Computer Science");
    }

    Student(String name, int age, String form, String subject) {

    }
}