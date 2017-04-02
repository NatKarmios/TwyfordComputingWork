package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Scanner;

import static com.karmios.nat.computingwork.utils.Utils.inputDoubleLoop;

public class Challenge02_SpeedTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Press enter to start the timer.");

        sc.nextLine();
        long start = System.currentTimeMillis();
        System.out.print("Timer started! Press enter again to stop it.");

        sc.nextLine();
        long end = System.currentTimeMillis();

        double time = (end-start)/1000.0;
        System.out.printf("\nTime elapsed: %s seconds.\n\n", time);
        System.out.printf("\nAverage speed: %sms⁻¹.\n",
                inputDoubleLoop("Enter distance in m: ", "Must be greater than 0!", x -> x>0) / time);
    }
}
