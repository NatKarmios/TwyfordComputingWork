package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Arrays;
import java.util.HashMap;

import static com.codepoetics.protonpack.StreamUtils.zipWithIndex;
import static com.karmios.nat.computingwork.utils.Utils.input;

public class Challenge28_NameThatNumber {
    private static final HashMap<Character, Character> map = new HashMap<>();
    static {
        Character[][] letters = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'},
                            {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
        zipWithIndex(Arrays.stream(letters))
                .forEach(indexed -> Arrays.stream(indexed.getValue())
                        .forEach(character -> map.put(character, (char) (indexed.getIndex()+50))));
    }

    public static void main(String[] args) {
        System.out.printf("  -> %s", input("Enter phrase: ").toUpperCase().chars().collect(
                StringBuilder::new,
                (builder, value) -> builder.append(map.getOrDefault((char) value, (char) value)),
                StringBuilder::append)
        .toString());
    }

}
