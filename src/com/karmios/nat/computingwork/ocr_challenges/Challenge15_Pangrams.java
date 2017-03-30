package com.karmios.nat.computingwork.ocr_challenges;

import com.karmios.nat.computingwork.utils.Utils;

import java.util.stream.IntStream;

public class Challenge15_Pangrams {
    public static void main(String[] args) {
        String input = Utils.input("Enter a phrase: ");
        System.out.printf("\"%s\" is%s a pangram.", input, (IntStream.range(65, 91)
                .allMatch(x -> input.toUpperCase().contains(Character.toString((char) x)))) ? "" : " not");
    }
}
