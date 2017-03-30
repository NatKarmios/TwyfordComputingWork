package com.karmios.nat.computingwork.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;


public class Math {
    public static boolean isPrime(int x) {
        return x >= 2 && ((x == 2) || IntStream.range(2, (int) sqrt(x)+1).allMatch(n -> x % n != 0));
    }

    public static void main(String[] args) {
        Arrays.stream(new int[] {1, 2, 4, 5, 16}).forEach(x -> System.out.printf("%s -> %s\n", x, isPrime(x)));
    }
}
