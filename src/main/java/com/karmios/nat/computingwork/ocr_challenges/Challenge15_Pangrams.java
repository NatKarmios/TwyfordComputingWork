package com.karmios.nat.computingwork.ocr_challenges;

import com.karmios.nat.computingwork.utils.Utils;

import java.util.stream.IntStream;

class Challenge15_Pangrams {
    public static void main(String[] args) {
        String input = Utils.input("Enter a phrase: ");
        System.out.printf("\"%s\" is%s a pangram.", input, isPangram(input) ? "" : " not");
    }

    static boolean isPangram(String str) {
        return IntStream.range(65, 91).allMatch(x -> str.toUpperCase().contains(Character.toString((char) x)));
    }
}
