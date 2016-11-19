package com.karmios.nat.computingwork.induction_tasks.section_3.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.karmios.nat.computingwork.utils.Utils;

public class Code {
    private static final String FILE_NAME = "Output.txt";

    private static final String[][] WORD_LISTS = {
            {"hot", "summer", "hard", "dry", "heavy", "light", "weak", "male", "sad", "win", "left", "front",
                    "up", "small", "ignore", "buy", "succeed", "reject", "prevent", "exclude"},

            {"cold", "winter", "soft", "wet", "light", "darkness", "strong", "female", "happy", "lose", "right", "back",
                    "down", "big", "pay attention", "sell", "fail", "accept", "allow", "include"}
    };

    private static int[] picked = new int[20];
    static { Arrays.fill(picked, -1); }

    public static void main(String[] args) {
        Random rng = new Random();
        Scanner sc = new Scanner(System.in);

        int score = 0;

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        for (int i = 0; i < 10; i++) {
            int pick1, pick2;

            while (pickedContains(pick1 = rng.nextInt(20)));
            picked[i] = pick1;

            while (pickedContains(pick2 = rng.nextInt(20)));
            picked[i+10] = pick2;

            print_question(pick1, pick2);
            if (sc.nextLine().equals(WORD_LISTS[1][pick2])) {
                System.out.println("Correct!");
                score++;
            }
            else System.out.println("Wrong!");
        }

        System.out.printf("%s, you scored %s out of 10.%n", name, score);

        writeResult(name, score);

    }

    private static void print_question(int num1, int num2) {
        System.out.printf("%s is to %s as %s is to... ",
                WORD_LISTS[0][num1], WORD_LISTS[1][num1], WORD_LISTS[0][num2]);
    }

    private static boolean pickedContains(int num) {
        return IntStream.of(picked).anyMatch(new Integer(num)::equals);
    }

    private static void writeResult (String name, int score) {
        String fileName = Utils.getDir(Code.class) + FILE_NAME;
        try {
            Files.write(
                    Paths.get(fileName), String.format("%s, %s%n", name, score).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Failed to write results to file.");
        }
    }
}
