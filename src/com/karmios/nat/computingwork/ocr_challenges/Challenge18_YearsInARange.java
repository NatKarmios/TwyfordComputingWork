package com.karmios.nat.computingwork.ocr_challenges;

import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.IS_NATURAL;
import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;

public class Challenge18_YearsInARange {
    public static void main(String[] args) {
        int start = inputIntLoop("Start year: ", "Need a natural number!", IS_NATURAL);
        int end = inputIntLoop("End year: ", String.format("Need an integer greater than %s!", start),
                x -> x>start);
        System.out.printf("The years with repeat digits between %s and %s are:\n", start, end);
        IntStream.rangeClosed(start, end).mapToObj(Integer::toString)
                .filter(s -> s.chars().distinct().count() < s.length()).forEach(s -> System.out.println(" - " + s));
    }
}
