package com.karmios.nat.ComputingWork.fundamentalsofprogramming.programmingproblems;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight: ");
        float weight = Float.valueOf(sc.nextLine());
        System.out.print("Enter height: ");
        float height = Float.valueOf(sc.nextLine());

        System.out.println("\nYour BMI is " + weight / (height * height));
    }
}
