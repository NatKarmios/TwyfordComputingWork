package com.karmios.nat.computingwork.ocr_challenges;

import com.karmios.nat.computingwork.utils.Utils;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.inputBoolLoop;
import static com.karmios.nat.computingwork.utils.Utils.sorted;

class Challenge25_Ordering {
    public static void main(String[] args) {
        System.out.println("Enter 10 numbers:");

        System.out.println("  -> " +
                sorted(new ArrayList<>(
                        IntStream.generate(Utils::inputIntLoop).limit(10).boxed()
                                .collect(Collectors.toList())),
                        inputBoolLoop("Reverse sort? ", true)).toString());
    }


}
