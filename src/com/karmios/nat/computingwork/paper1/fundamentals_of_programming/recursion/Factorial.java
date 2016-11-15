package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.recursion;

import java.util.Scanner;

/**
 * Created by Nat on 10/10/2016.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int num = Integer.valueOf(new Scanner(System.in).nextLine().replace(" ", ""));
        System.out.println(num + "! = " + fact(num));
    }

    static int fact(int n) {
        return n == 1 ? 1 : fact(n-1)*n;
    }

    static int factTail(int n, int curr) {
        return n==1 ? curr : factTail(n-1, curr);
    }
}
