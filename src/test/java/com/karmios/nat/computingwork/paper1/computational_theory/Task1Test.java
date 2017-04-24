package com.karmios.nat.computingwork.paper1.computational_theory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.karmios.nat.computingwork.paper1.computational_theory.Task1.*;

class Task1Test {
    @Test
    void maximumReturnsMaximumValue() {
        assertEquals(maximum(1, 2), 2);
        assertEquals(maximum(-1, 1), 1);
        assertEquals(maximum(-2, -1), -1);
    }

    @Test
    void maximumFailsWithNoArgs() {
        assertThrows(IllegalArgumentException.class, Task1::maximum);
    }

    @Test
    void maximumFailsWith1Arg() {
        assertThrows(IllegalArgumentException.class, () -> maximum(0));
    }


    @Test
    void maximum2ReturnsMaximumValue() {
        assertEquals(maximum2(1, 2), 2);
        assertEquals(maximum2(-1, 1), 1);
        assertEquals(maximum2(-2, -1), -1);
    }

    @Test
    void maximum2FailsWithNoArgs() {
        assertThrows(IllegalArgumentException.class, Task1::maximum2);
    }

    @Test
    void maximum2PassesWith1Arg() {
        assertEquals(maximum2(0), 0);
    }
}