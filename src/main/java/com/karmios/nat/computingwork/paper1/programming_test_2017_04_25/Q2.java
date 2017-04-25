package com.karmios.nat.computingwork.paper1.programming_test_2017_04_25;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How far to count?");
        int howFar = Integer.parseInt(sc.nextLine());
        while (howFar < 1) {
            System.out.println("Not a valid number, please try again.");
            howFar = Integer.parseInt(sc.nextLine());
        }

        for (int myLoop = 1; myLoop<=howFar; myLoop++) {
            if (myLoop%3==0 && myLoop%5==0) System.out.println("FizzBuzz");
            else if (myLoop%3==0) System.out.println("Fizz");
            else if (myLoop%5==0) System.out.println("Buzz");
            else System.out.println(myLoop);
        }
    }
}

