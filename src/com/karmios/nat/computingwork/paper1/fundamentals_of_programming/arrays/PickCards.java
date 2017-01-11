package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.arrays;

import java.util.Random;
import java.util.stream.IntStream;

@SuppressWarnings("Duplicates")
public class PickCards implements Runnable{
    private int card;

    public static void main(String[] args) {

    }

    public void run() {
        int[] picks = new int[4];
        Random rng = new Random();

        for (int i=0; i<4; i++) {
            do {
                card = rng.nextInt(52);
            } while (IntStream.of(picks).anyMatch((x -> x == card)));

            picks[i] = card;

            String suit = "";
            switch (card / 13) {
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
            switch (card % 13) {
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
                    num = String.valueOf((card % 13) + 1);
                    break;
            }

            System.out.println(num + " of " + suit);
        }
    }
}
