    package com.karmios.nat.computingwork.paper1.q3.exam.question2;

    import java.util.Scanner;

    public class Question2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int playerOneScore = 0;
            int playerTwoScore = 0;

            System.out.println("How many games?");
            int noOfGamesInMatch = sc.nextInt(); sc.nextLine();  // nextInt() doesn't clear the buffer of the new line.

            for (int NoOfGamesPlayed = 0; NoOfGamesPlayed < noOfGamesInMatch; NoOfGamesPlayed++) {
                System.out.println("Did Player One win the game (enter Y or N)?");
                String playerOneWinsGame = sc.nextLine();
                if (playerOneWinsGame.equals("Y")) playerOneScore++;
                else playerTwoScore++;
            }

            System.out.println(playerOneScore);
            System.out.println(playerTwoScore);
        }
    }

