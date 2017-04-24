package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

class CoinToss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        String p1 =  sc.nextLine();
        System.out.print("Enter Player 2's name: ");
        String p2 =  sc.nextLine();


        Random rng = new Random();
        int[] scores = IntStream.generate(() -> rng.nextInt(2)).limit(3).toArray();

        System.out.println((Arrays.stream(scores).filter(x -> x == 0).count() > 1 ? p1 : p2) + " won.");
        System.out.printf("%s: %s, %s: %s\n",
                p1, Long.valueOf(Arrays.stream(scores).filter(x -> x == 0).count()).toString(),
                p2, Long.valueOf(Arrays.stream(scores).filter(x -> x == 1).count()).toString()
                );
    }
}
