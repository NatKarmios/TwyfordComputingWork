package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

@SuppressWarnings("Duplicates")
public class RandomCardGenerator {
    static boolean[] picked = new boolean[52];
    static Random rng = new Random();

    public static void main(String[] args) {
        System.out.println(getCardStr());
    }

    public static int getCard() {
        int card;
        do {
            card = rng.nextInt(52);
        } while (picked[card]);

        picked[card] = true;
        return card;
    }

    public static String getCardStr() {
        return getCardStr(getCard());
    }

    public static String getCardStr(int card) {
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

        return num + " of " + suit;
    }

    public static int numPicked() {
        return (int) Arrays.stream(ArrayUtils.toObject(picked)).filter(x -> x).count();
    }
}
