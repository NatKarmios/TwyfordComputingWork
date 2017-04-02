package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Collections;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.inBounds;
import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;

public class Challenge26_TruthOrNot {
    public static void main(String[] args) {
        int n = inputIntLoop("How many inputs? (1-26) ", inBounds(1, 27));
        System.out.println("\n" + String.join("", Collections.nCopies(n*4+7, "=")));
        IntStream.range(0, n).forEach(x -> System.out.printf("| %s ", (char) (x+65)));
        System.out.println("| Out |");
        System.out.println(String.join("", Collections.nCopies(n*4+7, "=")));
        IntStream.range(0, (int) Math.pow(2, n)).forEach(x -> {
            IntStream.range(0, n).forEach(y -> System.out.printf("| %s ",
                    String.format("%26s", Integer.toBinaryString(x)).replace(' ', '0').charAt(26+y-n)));
            System.out.println("|     |");
        });
        System.out.println(String.join("", Collections.nCopies(n*4+7, "=")));
    }
}
