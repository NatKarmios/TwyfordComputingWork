package com.karmios.nat.computingwork.ocr_challenges;

import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.*;

class Challenge01_FactorialFinder {
    public static void main(String[] args) {
        int input = inputIntLoop(
                "Enter a number: ", "You must enter an integer that is at least 0!", x->x>=0);
        System.out.printf("%s! = %s", input,
                IntStream.rangeClosed(1, input).reduce(1, (result, current) -> result*current));
    }
}
