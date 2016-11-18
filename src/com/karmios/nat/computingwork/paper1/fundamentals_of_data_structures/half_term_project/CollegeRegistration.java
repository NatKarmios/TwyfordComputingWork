package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import org.apache.commons.lang3.ArrayUtils;

import static com.karmios.nat.computingwork.Utils.*;

import java.util.Arrays;

public class CollegeRegistration {
    private static final String[] options = {"+s", ".s", "+t", ".t", "+c", ".c"};

    public static void main(String[] args) {
        System.out.println("Please enter two characters - '+' to add or '.' to list, " +
                           "followed by 's' for students, 't' for teachers or 'c' for courses.");
        String option = inputLoop("Enter option: ", "Invalid option!", str -> ArrayUtils.contains(options, str));

    }
}
