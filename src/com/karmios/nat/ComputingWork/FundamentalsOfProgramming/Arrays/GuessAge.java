package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nat on 29/09/2016.
 */
public class GuessAge {
    static int score = 0;
    static Student[] students = new Student[10];

    static Scanner sc = new Scanner(System.in);
    static Random rng = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) students[i] = new Student();
        printSudents();
        for(int i=0; i<10; i++) {
            askQuestion();
        }
        System.out.println("\nFinal score: " + score + " out of 10.");
    }

    static void askQuestion() {
        shuffleStudents();

        System.out.print("Guess the age of the student in position 5: ");
        try  {
            if (Integer.valueOf(sc.nextLine().trim().replace(" ", "")) != students[5].getAge())
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Wrong, the answer was " + students[5].getAge() + ".\n");
            return;
        }

        System.out.println("Correct!\n");
        score++;
    }

    static void shuffleStudents() {
        Student[] shuffled = new Student[students.length];

        int place;
        for(int i=0; i<students.length; i++) {
            while (shuffled[(place = rng.nextInt(students.length))] != null);
            shuffled[place] = students[i];
        }

        students = shuffled;
    }

    static void printSudents() {
        System.out.println("Current students: ");
        for (Student stu : students) {
            stu.printPerson();
        }
        System.out.println();
    }
}

abstract class Person {
    static int numCreated = 1;


    String nameNum;
    int age;

    Person() {
        this(defaultName(), randAge());
    }

    Person(String name, int age) {
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
        return GuessAge.rng.nextInt(5)+16;
    }
}

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