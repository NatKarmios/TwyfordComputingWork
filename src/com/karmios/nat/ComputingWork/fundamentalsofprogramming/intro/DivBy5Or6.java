package com.karmios.nat.ComputingWork.fundamentalsofprogramming.intro;

import java.util.Scanner;

public class DivBy5Or6 {
    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        int num = new Scanner(System.in).nextInt();

        System.out.printf("\n5 and 6: %s", num%30==0);
        System.out.printf("\n5 or 6: %s", num%5==0 ^ num%6==0);
        System.out.printf("\n5 xor 6: %s", num%5==0 || num%6==0);
    }
}
