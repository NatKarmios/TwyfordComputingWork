package com.karmios.nat.computingwork.induction_tasks.section_3.Task1;

import java.util.Random;
import java.util.Scanner;

public class Code {
    private static String[][] WORD_LISTS = {
            {"hot", "summer", "hard", "dry", "heavy", "light", "weak", "male", "sad", "win",
                    "small", "ignore", "buy", "succeed", "reject", "prevent", "exclude"},

            {"cold", "winter", "soft", "wet", "light", "darkness", "strong", "female", "happy", "lose",
                    "big", "pay attention", "sell", "fail", "accept", "allow", "include"}
    };


    public static void main(String[] args) {
        Random rng = new Random();
        Scanner sc = new Scanner(System.in);

        int score = 0;

        System.out.print("Enter your name: ");
        String name = sc.next();

        for (int i = 0; i < 10; i++) {
            int pick1 = rng.nextInt(17);
            int pick2;
            while ((pick2 = rng.nextInt(17)) == pick1) ;

            print_question(pick1, pick2);
            if (sc.next().equals(WORD_LISTS[1][pick2])) {
                System.out.println("Correct!");
                score++;
            }
            else System.out.println("Wrong!");
        }

        System.out.printf("%s, you scored %s out of 10.%n", name, score);

    }

    private static void print_question(int num1, int num2) {
        System.out.printf("%s is to %s as %s is to... ",
                WORD_LISTS[0][num1], WORD_LISTS[1][num1], WORD_LISTS[0][num2]);
    }

}

