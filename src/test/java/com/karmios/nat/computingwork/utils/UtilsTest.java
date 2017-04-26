package com.karmios.nat.computingwork.utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.karmios.nat.computingwork.utils.Utils.*;

class UtilsTest {
    @Nested
    class RandInt {
        @Test
        void randIntStaysWithinBounds () {
            for (int i = 0; i < 1000; i++) {
                int rand = randInt(-10, 10);
                assertTrue(rand >= -10);
                assertTrue(rand < 10);
            }
        }
    }
}