package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static com.karmios.nat.computingwork.utils.Utils.*;

class Battleships {
    private static Boolean[][] grid = Stream.generate(() ->
            Stream.generate(() -> false).limit(10).toArray(Boolean[]::new)
    ).limit(10).toArray(Boolean[][]::new);

    public static void main(String[] args) {
        Random rng = new Random();
        int shipX = rng.nextInt(10);
        int shipY = rng.nextInt(10);

        for (int guesses = 10; guesses > 0; guesses--) {
            printGrid();
            System.out.println("\n" + guesses + " charge" + (guesses == 1 ? "" : "s") +" left.");
            int x = inputIntLoop("x: ", "You must enter a number between 0 and 9!", inBounds(0, 10));
            int y = inputIntLoop("y: ", "You must enter a number between 0 and 9!", inBounds(0, 10));

            if (x == shipX && y == shipY) {
                System.out.println("Hit! You win!");
                return;
            }

            System.out.println("Miss!");
            grid[y][x] = true;
        }
        System.out.println("Out of charges! You lose!");
    }

    private static void printGrid() {
        System.out.println("\n   0  1  2  3  4  5  6  7  8  9");
        final AtomicInteger count = new AtomicInteger(0);
        Arrays.stream(grid).forEach(row -> System.out.println(
                    count.getAndIncrement() + "  " +
                    Arrays.stream(row).map(x -> x ? "x" : "_").reduce("", (str, x) -> str + x + "  ").trim()
        ));
    }
}
