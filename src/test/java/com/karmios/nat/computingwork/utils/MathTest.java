package com.karmios.nat.computingwork.utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class MathTest {
    @Nested
    class IsPrime {
        final int[] PRIMES = {2, 5, 7};
        final int[] NON_PRIMES = {1, 4, 16};

        @Test
        void isPrimeReturnsTrueForPrimes() {
            for (int x : PRIMES) assertTrue(Math.isPrime(x));
        }

        @Test
        void isPrimeReturnsFalseForNonPrimes() {
            for (int x : NON_PRIMES) assertFalse(Math.isPrime(x));
        }
    }
}
