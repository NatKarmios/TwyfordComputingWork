package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.recursion;

import java.util.Scanner;

/**
 * Created by Nat on 10/10/2016.
 */
public class IntPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base number: ");
        int base = Integer.valueOf(sc.nextLine().replace(" ", ""));

        System.out.print("Enter exponent: ");
        int exp = Integer.valueOf(sc.nextLine().replace(" ", ""));
        System.out.println(base + "^" + exp  + " = " + intPow(base, exp));
    }

    static int intPow(int base, int exp) {
        return exp == 0 ? 1 : base * intPow(base, exp-1);
    }
}
