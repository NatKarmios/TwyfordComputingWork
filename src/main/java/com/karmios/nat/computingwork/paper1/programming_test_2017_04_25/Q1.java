package com.karmios.nat.computingwork.paper1.programming_test_2017_04_25;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Ben", "Thor", "Zoe", "Kate"};

        int max = 4;
        int current = 0;

        boolean found = false;
        System.out.println("What player are you looking for?");
        String playerName = sc.nextLine();
        while (!found && current<max)
            if (names[current].equals(playerName)) found = true;
            else current++;

        System.out.println(found ? "Yes, they have a top score" : "No, they don't have a top score.");
    }
}

