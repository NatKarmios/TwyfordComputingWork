package com.karmios.nat.ComputingWork.fundamentalsofprogramming.arrays;

import java.util.Random;
import java.util.stream.IntStream;

public class PickCards {
    static int card;

    public static void main(String[] args) {
        int[] picks = new int[4];
        Random rng = new Random();

        for (int i=0; i<4; i++) {
            do {
                card = rng.nextInt(52);
            } while (IntStream.of(picks).anyMatch((x -> x == card)));

            picks[i] = card;

            String suit = "";
            switch (card/13) {
                case 0:
                    suit = "Spades";
                    break;
                case 1:
                    suit = "Clubs";
                    break;
                case 2:
                    suit = "Hearts";
                    break;
                case 3:
                    suit = "Diamonds";
                    break;
            }

            String num;
            switch (card%13) {
                case 10:
                    num = "Jack";
                    break;
                case 11:
                    num = "Queen";
                    break;
                case 12:
                    num = "King";
                    break;
                case 0:
                    num = "Ace";
                    break;
                default:
                    num = String.valueOf((card%13)+1);
                    break;
            }

            System.out.println(num + " of " + suit);
        }
    }
}
