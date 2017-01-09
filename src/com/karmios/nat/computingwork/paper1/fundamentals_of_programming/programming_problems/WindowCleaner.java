package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class WindowCleaner {
    public static void main(String[] args) {
        final int height = inputIntLoop("Number of floors: ", "You must enter an integer greater than 0!", x -> x>0);
        final int width = inputIntLoop("Rooms per floor: ", "You must enter an integer greater than 0!", x -> x>0);
        final long delay = 500;
        cleanWindows(width, height, delay);
    }

    private static void cleanWindows(int width, int height, long delay) {
        new Thread(() -> {  // Multithread to allow program to do other things
            final AtomicBoolean isReversed = new AtomicBoolean(false);
            IntStream.range(0, height).forEach(y -> {  // For each floor...
                    IntStream.range(0, width).map(x -> isReversed.get() ? width-(x+1) : x).forEach(x -> {  // For each room...
                                clean(x+1, y+1);  // Instruct the robot to clean the windows
                                try {
                                    Thread.sleep(delay);  // Wait for the given delay
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                    });
                    isReversed.set(!isReversed.get());
            });
        }).start();
    }

    private static void clean(int x, int y) {
        System.out.printf("{\"clean\": {\"floor\": %s, \"room\": %s}}\n", y, x);
    }
}
