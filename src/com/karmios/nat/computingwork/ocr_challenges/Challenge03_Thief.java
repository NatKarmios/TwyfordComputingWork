package com.karmios.nat.computingwork.ocr_challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.inputLoop;

public class Challenge03_Thief {
    public static void main(String[] args) {
        String pin = inputLoop("Enter digits: ", "You must enter digits only!",
                str -> str.matches("\\d+"));
        permutations(pin).forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Character>> permutations(ArrayList<Character> chars) {
        if (chars.size() == 1) return new ArrayList<>(Collections.singletonList(chars));

        ArrayList<ArrayList<Character>> results = new ArrayList<>();
        IntStream.range(0, chars.size()).forEach((i) -> {
            ArrayList<Character> current = new ArrayList<>(chars);
            Character front = current.remove(i);
            permutations(current).stream().map(perm -> {perm.add(0, front); return perm;}).forEach(results::add);
        });
        return results;
    }

    private static List<String> permutations(String str) {
        return permutations(new ArrayList<>(str.chars().mapToObj(e -> (char) e).collect(Collectors.toList())))
                .stream().map(characters -> characters.stream().map(Object::toString).collect(Collectors.joining()))
                .distinct().sorted().collect(Collectors.toList());
    }
}
