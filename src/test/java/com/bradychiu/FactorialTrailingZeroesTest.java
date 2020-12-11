package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTrailingZeroesTest {

    private static int runSolution(int n) {
        // return FactorialTrailingZeroes.trailingZeroesComputeFactorial(n);
        // return FactorialTrailingZeroes.trailingZeroesFactorsOfFive(n);
        // return FactorialTrailingZeroes.trailingZeroesFactorsOfFiveFaster(n);
        // return FactorialTrailingZeroes.trailingZeroesFactorsOfFiveCleaner(n);
        return FactorialTrailingZeroes.trailingZeroesFactorsOfFiveOneLiner(n);
    }

    @Test
    void one() {
        assertEquals(0, runSolution(3));
    }

    @Test
    void two() {
        assertEquals(1, runSolution(5));
    }

    @Test
    void three() {
        assertEquals(0, runSolution(0));
    }

    @Test
    void four() {
        assertEquals(2, runSolution(13));
    }

    @Test
    void five() {
        assertEquals(7, runSolution(30));
    }

}