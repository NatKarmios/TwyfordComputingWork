package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Intro;

import java.util.Scanner;

public class ComputArea {
    public static void main(String[] args) {
        double radius, area;  // Declare radius and area variables

        System.out.print("Enter radius: ");
        radius = new Scanner(System.in).nextDouble();

        area = radius * radius * Math.PI;

        System.out.printf("r = %s; A = %s", radius, area);
    }
}
