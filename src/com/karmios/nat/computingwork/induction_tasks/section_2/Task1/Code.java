package com.karmios.nat.computingwork.induction_tasks.section_2.Task1;

import java.util.Scanner;

public class Code {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter their weight in pounds
        System.out.print("Enter your weight in pounds: ");
        double weight = input.nextDouble();

        //Prompt the user to enter their height in inches
        System.out.print("Enter your height in inches: ");
        double height = input.nextDouble();

        final double KG_PER_POUNDS = 0.45359237;// Constant
        final double M_PER_INCH = 0.0254;// Constant

        // Compute BMI
        double weightInKg = weight * KG_PER_POUNDS;
        double heightInMetres = height * M_PER_INCH;
        double bmi = weightInKg / (heightInMetres * heightInMetres);


        // Display result
        System.out.println("Your BMI is:  " + bmi);
        if (bmi < 18.5) System.out.println("Underweight");
        else if (bmi < 25) System.out.println("Normal");
        else if (bmi < 30) System.out.println("Overweight");
        else System.out.println("Obese");
    }

}
