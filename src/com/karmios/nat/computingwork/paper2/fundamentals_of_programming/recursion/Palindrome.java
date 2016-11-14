package com.karmios.nat.computingwork.paper2.fundamentals_of_programming.recursion;

import java.util.Scanner;

/**
 * Created by Nat on 05/10/2016.
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.print("Enter string: ");
        String str = new Scanner(System.in).nextLine();
        System.out.println("\"" + str + "\" IS " + (isPalindrome(str) ? "" : "NOT ") + "a palindrome.");
    }

    static boolean isPalindrome(String str) {
        return str.length() <= 1 ||
                str.charAt(0) == str.charAt(str.length() - 1)
                && isPalindrome(str.substring(1, str.length() - 1));
    }
}
