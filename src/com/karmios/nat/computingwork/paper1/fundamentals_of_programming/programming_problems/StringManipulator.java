package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;

public class StringManipulator {
    static int Length (String s){
        return s.length();
    }

    static void PrintFirstLetter (String s) {
        System.out.println(s.charAt(0));
    }

    static String ToUpper (String s) {
        return s.toUpperCase();
    }

    static void PrintEachChar(String s) {
        s.chars().forEach(x -> System.out.println((char)x));
    }

    static String Reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
