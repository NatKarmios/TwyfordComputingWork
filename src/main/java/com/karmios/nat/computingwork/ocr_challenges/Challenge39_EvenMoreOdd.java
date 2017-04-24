package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.randInt;

class Challenge39_EvenMoreOdd {
    private static final int max = 100;

    public static void main(String[] args) {
        int[] nums = IntStream.generate(() -> randInt(max)).limit(10).toArray();
        System.out.printf("%s\n  -> %s\n", Arrays.toString(nums), Arrays.toString(Arrays.stream(nums).boxed()
                .sorted(Comparator.comparingInt(x -> x % 2 == 0 ? max + x : x)).mapToInt(Integer::intValue).toArray()));
    }
}
