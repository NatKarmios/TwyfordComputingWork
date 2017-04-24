package com.karmios.nat.computingwork.ocr_challenges;

import static com.karmios.nat.computingwork.utils.Utils.input;
import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;

class Challenge13_CaesarCipher {
    public static void main(String[] args) {
        int key = inputIntLoop("Key: ");
        System.out.printf("  -> %s",
                input("Phrase: ").chars().mapToObj(x ->
                    (char) ((x >= 65 && x < 91) ? (((x-65)+key)%26)+65 :
                            (x >= 97 && x < 113) ? (((x-97)+key)%26)+97 : x)
                ).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }
}
