package com.karmios.nat.computingwork.paper2.fundamentals_of_programming.programming_problems;

import java.util.Arrays;

import static com.karmios.nat.computingwork.Utils.*;

public class NoughtsAndCrosses {
    private static int[][] board = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    private static boolean noughtsTurn = true;
    private static final int[] all1 = {1, 1, 1};
    private static final int[] all0 = {0, 0, 0};

    public static void main(String[] args) {
        while (true) {
            printBoard();

            System.out.println((noughtsTurn ? "Nought's" : "Cross'") + " turn...");
            int x, y;
            do {
                x = inputIntLoop("x: ", "You must enter a number between 0 and 2!", inBounds(0, 3));
                y = inputIntLoop("y: ", "You must enter a number between 0 and 2!", inBounds(0, 3));
            } while (board[y][x] != -1);

            board[y][x] = noughtsTurn ? 0 : 1;

            if (checkBoard()) {
                printBoard();
                System.out.println((noughtsTurn ? "Noughts" : "Crosses") + " wins!");
                return;
            }

            if (Arrays.stream(board).allMatch(row -> Arrays.stream(row).allMatch(n -> n != -1))) {
                printBoard();
                System.out.println("It's a tie!");
                return;
            }

            noughtsTurn = !noughtsTurn;
        }
    }

    private static void printBoard() {
        System.out.println("\n  012");
        for (int y = 0; y < 3; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < 3; x++) {
                switch (board[y][x]){
                    case -1:
                        System.out.print(" ");
                        break;
                    case 0:
                        System.out.print("O");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                }
            }
            System.out.println();
        }
    }

    private static boolean checkBoard() {
        // rows + cols
        for (int i = 0; i < 3; i++) {
            int[] row = {board[i][0], board[i][1], board[i][2]};
            int[] col = {board[0][i], board[1][i], board[2][i]};
            if (Arrays.equals(row, all0) || Arrays.equals(row, all1) ||
                    Arrays.equals(col, all0) || Arrays.equals(col, all1)) return true;
        }
        int[] diag1 = {board[0][0], board[1][1], board[2][2]};
        int[] diag2 = {board[0][2], board[1][1], board[2][0]};

        return Arrays.equals(diag1, all0) || Arrays.equals(diag1, all1) ||
                Arrays.equals(diag2, all0) || Arrays.equals(diag2, all1);

    }
}
