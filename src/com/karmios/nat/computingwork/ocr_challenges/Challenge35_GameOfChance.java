package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

import static com.karmios.nat.computingwork.utils.Math.isPrime;
import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;
import static com.karmios.nat.computingwork.utils.Utils.randInt;

public class Challenge35_GameOfChance {
    private static final IntUnaryOperator[] multipliers = {
            x -> (x<5) ? 2:1,
            x -> (x%2==0) ? 2:1,
            x -> (x%10==0) ? 3:1,
            x -> isPrime(x) ? 5:1
    };

    public static void main(String[] args) {
        final int roll, bet, guess;
        bet = inputIntLoop("How much to bet? ");
        roll = randInt(31);
        guess = inputIntLoop("On what number (0-30)? ");
        System.out.printf("You won %s [Roll was %s]\n", bet*(roll==guess?1:0)*((IntSupplier) () -> {
            AtomicInteger n = new AtomicInteger(1);
            Arrays.stream(multipliers).forEach(multiplier -> n.set(n.get()*multiplier.applyAsInt(guess)));
            return n.get();
        }).getAsInt(), roll);
    }
}
