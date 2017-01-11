package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int num = new Scanner(System.in).nextInt();
        System.out.println("The Fibonacci term " + num + " is " + fibb(num));
    }

    private static int fibb(int n) {
        return n>1 ? (fibb(n-1) + fibb(n-2)) : n;
    }
}
