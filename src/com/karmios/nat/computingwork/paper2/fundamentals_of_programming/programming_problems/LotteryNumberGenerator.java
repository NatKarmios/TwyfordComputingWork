package com.karmios.nat.computingwork.paper2.fundamentals_of_programming.programming_problems;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class LotteryNumberGenerator {
    public static void main(String[] args) {
        Random rng = new Random();

        int[] nums = IntStream.generate(() -> rng.nextInt(49)+1).limit(7).toArray();

        System.out.println("Lottery Numbers:");
        Arrays.stream(nums).limit(6).forEach(System.out::println);
        System.out.println("Bonus number: " + nums[6]);
    }
}
