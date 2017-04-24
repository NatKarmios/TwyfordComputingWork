package com.karmios.nat.computingwork.ocr_challenges;

import static com.karmios.nat.computingwork.utils.Utils.input;

class Challenge32_CodeItUp {
    public static void main(String[] args) {
        System.out.println("  -> " + input("Enter word: ").chars().mapToObj(x -> (char) (x+25))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }
}
