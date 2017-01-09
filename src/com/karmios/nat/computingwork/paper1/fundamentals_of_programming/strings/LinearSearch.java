package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.strings;

import java.util.Scanner;

/**
 * This question is a little less broken, albeit riddled with bad practice - a for-loop is much more appropriate here
 * than a while loop, or even better, an enhanced for-loop could be used.
 * <p>
 * As is traditional at this point with AQA's pseudocode, 1-based indexing is used, successfully confusing students
 * into using the awful practice of 1-based indexing and ignoring index 0.
 */

public class LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Scanner object required for inputting values

        String[] names = {"Ben", "Thor", "Zoe", "Kate"};  // Preformed list directly assigned, instead of line-by-line population
        int max = 3;
        int current = 0;  // Corrected from pseudocode in order to use 0-based indexing
        boolean found = false;
        System.out.println("What player are you looking for?");
        String playerName = in.nextLine();
        while (!found && current <= max) {  // Manual boolean operation simplified
            if (names[current].equals(playerName)) found = true;  // .equals() is required instead of equality operator
            else current++;  // Increment operator used for clarity
        }
        if (found) System.out.println("Yes, they have a top score");  // Manual boolean comparison simplified
    }
}
