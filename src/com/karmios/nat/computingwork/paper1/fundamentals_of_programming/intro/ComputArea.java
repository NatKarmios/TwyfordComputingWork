package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

import java.util.Scanner;

public class ComputArea implements Runnable {
    public static void main(String[] args) {
        new ComputArea().run();
    }

    @Override
    public void run() {
        double radius, area;  // Declare radius and area variables

        System.out.print("Enter radius: ");
        radius = new Scanner(System.in).nextDouble();

        area = radius * radius * Math.PI;

        System.out.printf("r = %s; A = %s", radius, area);
    }
}
