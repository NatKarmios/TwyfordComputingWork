package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PiggyBankCalculator {
    public static void main(String[] args) {
        final int[] coinVals = {1, 2, 5, 10, 20, 50, 100, 200};
        final String[] coinNames = {"1p", "2p", "5p", "10p", "20p", "50p", "£1", "£2"};
        final AtomicInteger total = new AtomicInteger(0);

        final Scanner sc = new Scanner(System.in);
        IntStream.range(0, 8).forEach(i -> {
            System.out.printf("How many %s coins? ", coinNames[i]);
            total.addAndGet(coinVals[i] * Integer.valueOf(sc.nextLine()));
        });

        System.out.println("Total: £" + ((float) total.get()) / 100);
    }
}
