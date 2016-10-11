package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Strings;

import java.util.Scanner;

/**
 * Note to self:
 * This is a stupid question.
 *
 * I had to follow an unclear and inefficient flowchart, this is not my logic.
 */

public class BinaryToDenary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int answer = 0;
        int column = 8;
        do {
            System.out.print("Enter bit value: ");
            int bit = in.nextInt();
            if (bit < 0 || bit > 1) {
                System.out.println("That's mathematically undefined, you twit.");
                return;
            }
            answer += column * bit;
            column /= 2;
        } while (column >= 1);

        System.out.println("Decimal value is: " + answer);
    }
}
