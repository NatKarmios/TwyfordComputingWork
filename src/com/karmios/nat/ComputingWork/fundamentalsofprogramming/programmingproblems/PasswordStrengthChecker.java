package com.karmios.nat.ComputingWork.fundamentalsofprogramming.programmingproblems;

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        System.out.print("Enter password: ");
        String pass = new Scanner(System.in).nextLine();

        System.out.println(
            pass.length() > 5 &&
            pass.chars().anyMatch(x -> Character.isLetter((char)x)) &&
            pass.chars().anyMatch(x -> Character.isDigit((char)x)) &&
            pass.chars().anyMatch(x -> !Character.isLetterOrDigit((char)x))
            ? (pass.length() > 7 ? "STRONG" : "MEDIUM") : "WEAK"
        );
    }


}
