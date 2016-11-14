package com.karmios.nat.computingwork.induction_tasks.section_2.Task2;

import java.util.Random;
import java.util.stream.IntStream;

public class Code {

    public static void main(String[] args){
        Random rng = new Random();
        int[] pickedNumbers = new int[7];

        for(int i=0; i<7; i++) {
            int picked;
            do {
                picked = rng.nextInt(49) + 1;
            } while (IntStream.of(pickedNumbers).anyMatch(new Integer(picked)::equals));

            pickedNumbers[i] = picked;
        }

        System.out.println("Lottery numbers:");
        for(int i=0; i<6;
            System.out.println(pickedNumbers[i++]));

        System.out.println("Bonus ball: " + pickedNumbers[6]);
    }
}
