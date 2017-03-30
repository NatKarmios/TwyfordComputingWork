package com.karmios.nat.computingwork.ocr_challenges;

import static com.karmios.nat.computingwork.utils.Utils.input;

public class Challenge29_ForwardsAndBackwards {
    public static void main(String[] args) {
        String str = input("Enter a phrase: ");
        System.out.printf("\"%s\" is%s a palindrome.", str,
                new StringBuilder(str).reverse().toString().equals(str) ? "" : " not");
    }
}
