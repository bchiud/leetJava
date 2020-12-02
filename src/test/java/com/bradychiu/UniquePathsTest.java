package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {

    private static int runSolution(int m, int n) {
        // return UniquePaths.uniquePathsRecursive(m, n);
        return UniquePaths.uniquePathsDP(m, n);
    }

    @Test
    void one() {
        int m = 3;
        int n = 7;
        int expected = 28;

        assertEquals(expected, runSolution(m, n));
    }

    @Test
    void two() {
        int m = 3;
        int n = 2;
        int expected = 3;

        assertEquals(expected, runSolution(m, n));
    }

    @Test
    void three() {
        int m = 7;
        int n = 3;
        int expected = 28;

        assertEquals(expected, runSolution(m, n));
    }

    @Test
    void four() {
        int m = 3;
        int n = 3;
        int expected = 6;

        assertEquals(expected, runSolution(m, n));
    }

    @Test
    void five() {
        int m = 1;
        int n = 1;
        int expected = 1;

        assertEquals(expected, runSolution(m, n));
    }
}