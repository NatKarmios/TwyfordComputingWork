package com.karmios.nat.computingwork.paper2.fundamentals_of_programming.programming_problems;

import static com.karmios.nat.computingwork.Utils.*;
import static com.karmios.nat.computingwork.paper2.fundamentals_of_programming.programming_problems.RandomCardGenerator.*;

@SuppressWarnings("WeakerAccess")
public class PlayYourCardsRight {
    public static void main(String[] args) {
        System.out.println("You scored " + play() + ".");
    }

    public static int play() {
        int card = getCard();
        int prevCard;

        do {

            int ans;
            prevCard = card;
            card = getCard();
            try {
                ans = inputInt(
                        "Card " + (numPicked()+1) + " is the " + getCardStr(prevCard) +
                                ". Higher (1) or lower (0)? ",
                        x -> x == 1 || x == 0
                );
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input! You lose!");
                return numPicked();
            }

            if (ans == 1 ? prevCard%13 > card%13 : prevCard%13 < card%13){
                System.out.println("Too bad! The card was the " + getCardStr(card) + ".");
                return numPicked();
            }

        } while (numPicked() < 52);

        System.out.println("You win!");
        return numPicked();
    }
}
