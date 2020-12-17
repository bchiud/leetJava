package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTwoIntegersTest {
    private static int runSolution(int dividend, int divisor) {
        // return DivideTwoIntegers.divideSubtraction(dividend, divisor);
        return DivideTwoIntegers.divideExponentialSearch(dividend, divisor);
    }

    @Test
    void one() {
        assertEquals(3, runSolution(10, 3));
    }

    @Test
    void two() {
        assertEquals(-2, runSolution(7, -3));
    }

    @Test
    void three() {
        assertEquals(0, runSolution(0, 1));
    }

    @Test
    void four() {
        assertEquals(1, runSolution(1, 1));
    }

    @Test
    void five() {
        assertEquals(100000, runSolution(1000000, 10));
    }
}