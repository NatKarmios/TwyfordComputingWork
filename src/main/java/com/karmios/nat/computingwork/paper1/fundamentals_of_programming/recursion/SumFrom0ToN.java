package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.recursion;

import java.util.Scanner;

public class SumFrom0ToN {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int num = Integer.valueOf(new Scanner(System.in).nextLine().replace(" ", ""));

        System.out.println("Sum from 0 to " + num + " = " + sumToN(num));
    }

    private static int sumToN(int n) {
        return n==0 ? 0 : n+sumToN(n-1);
    }
}
