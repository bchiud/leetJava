package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowTest {

    private static double runSolution(double x, int n) {
        // return Pow.myPowBrute(x, n);
        // return Pow.myPowRecursive(x, n);
        // return Pow.myPowRecursiveCleaner(x, n);
        return Pow.myPowIterative(x, n);
    }

    @Test
    void one() {
        assertEquals(1024, runSolution(2, 10));
    }

    @Test
    void two() {
        assertEquals(9.261, runSolution(2.1, 3));
    }

    @Test
    void three() {
        assertEquals(0.25, runSolution(2, -2));
    }

}