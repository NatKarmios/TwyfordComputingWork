package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Recursion;

import java.util.Scanner;

/**
 * Created by Nat on 05/10/2016.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int num = new Scanner(System.in).nextInt();
        System.out.println("The Fibonacci term " + num + " is " + fibb(num));
    }

    static int fibb(int n) {
        return n>1 ? (fibb(n-1) + fibb(n-2)) : n;
    }
}
