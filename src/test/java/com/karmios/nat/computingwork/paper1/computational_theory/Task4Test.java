package com.karmios.nat.computingwork.paper1.computational_theory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    void primeFactorsReturnsPrimeFactors() {
        assertArrayEquals(new int[]{2}, Task4.primeFactors(2));
        assertArrayEquals(new int[]{2, 2, 2, 2, 2, 2}, Task4.primeFactors(64));
        assertArrayEquals(new int[]{2, 3}, Task4.primeFactors(6));
        assertArrayEquals(new int[]{2, 2, 5, 5}, Task4.primeFactors(100));
    }

    @Test
    void primeFactorsFailsForIntegersLessThan2() {
        assertThrows(IllegalArgumentException.class, () -> Task4.primeFactors(1));
        assertThrows(IllegalArgumentException.class, () -> Task4.primeFactors(0));
        assertThrows(IllegalArgumentException.class, () -> Task4.primeFactors(-1));
    }
}