package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Challenge23_Fibbing {
    public static void main(String[] args) {
        System.out.println("Fibonacci sequence to 10 places: " +
                Arrays.toString(IntStream.range(1, 11).map(Challenge23_Fibbing::fib).toArray()));
    }

    private static int fib(int n) {
        return n>1 ? (fib(n-1) + fib(n-2)) : n;
    }
}
