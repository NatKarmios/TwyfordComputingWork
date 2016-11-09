package com.karmios.nat.ComputingWork.fundamentalsofprogramming.programmingproblems;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


import static com.codepoetics.protonpack.StreamUtils.zip;


import static com.karmios.nat.ComputingWork.Utils.*;

public class ScrabbleWordChecker {

    static final File WORDS_LIST = new File(getDir(ScrabbleWordChecker.class) + "scrabblewords.txt");

    static final HashMap<Character, Integer> scores = new HashMap<>();
    static {
        int[] scoreVals = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        IntStream.range(0, 26).forEach(x -> scores.put((char)(x+65), scoreVals[x]));
    }

    public static void main(String[] args) {
        String word = inputLoop("Enter word: ", "That word is invalid!", in -> {
                    try {
                        return Files.lines(WORDS_LIST.toPath()).anyMatch(in.toUpperCase()::equals);
                    } catch (IOException e) {
                        System.out.println("Couldn't read scrabblewords.txt!");
                        System.exit(1);
                    }
                    return false;
                }
        ).toUpperCase();

        System.out.println("The word '" + word + "' scores " + getWordScore(word) + " points.");
    }

    public static int getWordScore(String word) {
        final AtomicInteger count = new AtomicInteger();
        word.chars().forEach(x -> count.addAndGet(scores.get((char) x)));
        return count.get();
    }
}
