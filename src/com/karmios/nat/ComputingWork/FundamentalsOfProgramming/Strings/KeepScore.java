package com.karmios.nat.ComputingWork.FundamentalsOfProgramming.Strings;

import java.util.Scanner;

/**
 * This question was even worse - the pseudocode got corrupted, so all the newlines were removed and all the assignment
 * operators were replaced with quotation marks.
 *
 * Step it up, Computing Department.
 */

public class KeepScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int playerOneScore = 0;
        int playerTwoScore = 0;
        System.out.println("How many games?");
        int noOfGamesInMatch = in.nextInt();
        for (int noOfGamesPlayed = 1; noOfGamesPlayed <= noOfGamesInMatch; noOfGamesPlayed++) {
            System.out.println("Did Player One win the game (enter Y or N)?");
            char playerOneWinsGame = in.next().charAt(0);
            if (playerOneWinsGame == 'Y') playerOneScore++;
            else playerTwoScore++;
        }
        System.out.println(playerOneScore);
        System.out.println(playerTwoScore);
    }
}
