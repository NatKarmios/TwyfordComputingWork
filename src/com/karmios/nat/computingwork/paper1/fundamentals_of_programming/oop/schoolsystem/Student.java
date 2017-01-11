package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.schoolsystem;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import static com.karmios.nat.computingwork.utils.Utils.*;

@SuppressWarnings("WeakerAccess")
public class Student {
    public String name;
    public LocalDate dateOfBirth;
    public String nameOfSchool;

    public Student(String name, LocalDate dateOfBirth, String nameOfSchool) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nameOfSchool = nameOfSchool;
    }

    public Student() {
        String name = StringUtils.capitalize(inputLoop("Enter your name: ",
                "Your name must only contain letters, spaces and hyphens!", matchesRegex("^(A-Za-z\\- )$")).trim());
        LocalDate dateOfBirth = LocalDate.parse(inputLoop(
                "Enter your date of birth (YYYY-MM-DD): ", "You must enter a valid date!", IS_DATE));
        String nameOfSchool = StringUtils.capitalize(input("Enter your school's name:").trim());
    }

    public void doHomework(){}

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }
}
