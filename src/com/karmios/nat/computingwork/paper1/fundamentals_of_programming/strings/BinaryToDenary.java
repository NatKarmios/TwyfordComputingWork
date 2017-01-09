package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.strings;

import java.util.Scanner;

/**
 * Note to self:
 * This is a stupid question; I had to follow an unclear and inefficient flowchart; this is not my logic.
 * <p>
 * Side note:
 * Yes I know, that's a bit of sassy error-handling and commenting. So I had a tiny bit of fun. Sue me.
 */

public class BinaryToDenary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int answer = 0;
        int column = 8;  // A cute way of visualising binary conversion. Grow up, AQA.
        do {
            System.out.print("Enter bit value: ");
            int bit = in.nextInt();  // Forcing a user to manually enter each bit is completely unnecessary - all it managed to do was stop me from using an inline-instantiated Scanner object. Boo.
            if (bit < 0 || bit > 1) {
                System.out.println("That's mathematically undefined, you twit.");  // Added attitude, reflects my own towards AQA.
                return;  // This is the error handling response I like to call: "F*** this s***, I'm out."
            }
            answer += column * bit;  // AQA likes to cut their code up into neat little lines before they make computers snort it.
            column /= 2;  // This definitely needed to be a while loop. I think AQA is racist against for-loops.
        } while (column >= 1);

        System.out.println("Decimal value is: " + answer);
    }
}
