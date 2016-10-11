package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Intro;

import java.util.Scanner;

public class DisplayTime {
    public static void main(String[] args) {
        int seconds;

        System.out.print("Enter seconds: ");
        seconds = new Scanner(System.in).nextInt();

        System.out.printf("%ss = %sh, %sm, %ss", seconds, seconds/3600, (seconds/60)%60, seconds%60);
    }
}
