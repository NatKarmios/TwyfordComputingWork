package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a, b and c:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double discriminant = discriminant(a, b, c);

        if (Double.isNaN(discriminant)) {
            System.out.println("No roots.");
            return;
        }

        double x1 = (-b + discriminant) / (2*a);
        double x2 = (-b - discriminant) / (2*a);

        System.out.println("x = " + String.valueOf(x1) + (x1 != x2 ?(", " + String.valueOf(x2)) : ""));

    }

    private static double discriminant(double a, double b, double c) {
        return Math.sqrt((b*b) - (4*a*c));
    }
}
