package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Strings;

import java.util.Scanner;

/**
 * Created by Nat on 11/10/2016.
 */
public class LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] names = {"Ben", "Thor", "Zoe", "Kate"};
        int max = 3;
        int current = 0;  // Corrected - pseudocode uses 1-based indexing
        boolean found = false;
        System.out.println("What player are you looking for?");
        String playerName = in.nextLine();
        while (found==false && current<=max) {
            if (names[current].equals(playerName)) found = true;
            else current++;
        }
        if (found) System.out.println("Yes, they have a top score");
    }
}
