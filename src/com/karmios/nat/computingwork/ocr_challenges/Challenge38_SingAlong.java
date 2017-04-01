package com.karmios.nat.computingwork.ocr_challenges;

import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;

public class Challenge38_SingAlong {
    public static void main(String[] args) {
        int n = inputIntLoop("What number to start from?");
        IntStream.range(0, n).forEach(x ->
        System.out.printf(
                "%1$s green bottle%3$s hanging on the wall\n" +
                "%1$s green bottle%3$s hanging on the wall\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be %2$s green bottle%4$s hanging on the wall.\n\n",
                n-x, (n-x==1 ? "no more" : n-x-1), (n-x==1 ? "" : "s"), (n-x-1==1 ? "" : "s")
        ));
    }
}
