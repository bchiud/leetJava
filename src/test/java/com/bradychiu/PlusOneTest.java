package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

    private static int[] runSolution(int[] digits) {
        return PlusOne.plusOne(digits);
    }

    @Test
    void one() {
        int[] digits = new int[]{1, 2, 3};
        int[] expected = new int[]{1, 2, 4};

        assertArrayEquals(expected, runSolution(digits));
    }

    @Test
    void two() {
        int[] digits = new int[]{4, 3, 2, 1};
        int[] expected = new int[]{4, 3, 2, 2};

        assertArrayEquals(expected, runSolution(digits));
    }

    @Test
    void three() {
        int[] digits = new int[]{0};
        int[] expected = new int[]{1};

        assertArrayEquals(expected, runSolution(digits));
    }

    @Test
    void four() {
        int[] digits = new int[]{9,9,9,9,9};
        int[] expected = new int[]{1,0,0,0,0,0};

        assertArrayEquals(expected, runSolution(digits));
    }

    @Test
    void five() {
        int[] digits = new int[]{8,9,9,9};
        int[] expected = new int[]{9,0,0,0};

        assertArrayEquals(expected, runSolution(digits));
    }

    @Test
    void six() {
        int[] digits = new int[]{9};
        int[] expected = new int[]{1,0};

        assertArrayEquals(expected, runSolution(digits));
    }

}