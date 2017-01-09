package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.recursion;

import java.util.Scanner;

/**
 * Created by Nat on 10/10/2016.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: 1");
        int num1 = Integer.valueOf(sc.nextLine().replace(" ", ""));

        System.out.print("Enter number 2: ");
        int num2 = Integer.valueOf(sc.nextLine().replace(" ", ""));

        System.out.println("The Greatest Common Divisor of " + num1 + " and " + num2 + " is " + GCD(num1, num2) );
    }

    static int GCD(int a, int b) {
        return b==0 ? a : GCD(b, a%b);
    }
}
