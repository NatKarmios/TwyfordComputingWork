package com.karmios.nat.computingwork.ocr_challenges;

import static com.karmios.nat.computingwork.utils.Utils.inputLoop;

class Challenge30_YearAddition {
    public static void main(String[] args) {
        System.out.printf("  -> %s\n", inputLoop("Enter number: ", "You must enter a natural number!",
                str -> str.matches("^\\d+$")).chars().reduce(0, (total, current) -> total+current-48));
    }
}
