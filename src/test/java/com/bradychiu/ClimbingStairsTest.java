package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    private static int runSolution(int n) {
        return ClimbingStairs.climbStairsRecursive(n);
        // return ClimbingStairs.climbStairsDynamicProgramming(n);
    }

    @Test
    void one() {
        assertEquals(1, runSolution(1));
    }

    @Test
    void two() {
        assertEquals(2, runSolution(2));
    }

    @Test
    void three() {
        assertEquals(3, runSolution(3));
    }

    @Test
    void four() {
        assertEquals(5, runSolution(4));
    }

    @Test
    void five() {
        assertEquals(8, runSolution(5));
    }

    @Test
    void six() {
        assertEquals(13, runSolution(6));
    }
}