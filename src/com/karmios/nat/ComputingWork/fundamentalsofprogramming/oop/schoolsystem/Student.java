package com.karmios.nat.ComputingWork.fundamentalsofprogramming.oop.schoolsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Student {
    public String name;
    public LocalDate dateOfBirth;
    public String nameOfSchool;

    public Student(String name, LocalDate dateOfBirth, String nameOfSchool) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nameOfSchool = nameOfSchool;
    }

    public void doHomework(){}

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }
}
