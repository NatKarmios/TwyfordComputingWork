package com.karmios.nat.ComputingWork.fundamentalsofprogramming.recursion;

import java.util.Scanner;

/**
 * Created by Nat on 10/10/2016.
 */
public class SumFrom0ToN {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int num = Integer.valueOf(new Scanner(System.in).nextLine().replace(" ", ""));

        System.out.println("Sum from 0 to " + num + " = " + sumToN(num));
    }

    static int sumToN(int n) {
        return n==0 ? 0 : n+sumToN(n-1);
    }
}
