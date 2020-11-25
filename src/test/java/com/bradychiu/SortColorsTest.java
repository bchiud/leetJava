package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortColorsTest {

    private static void runSolution(int[] nums) {
        // SortColors.sortColorsTwoPass(nums);
        SortColors.sortColorsOnePass(nums);
    }

    @Test
    void one() {
        int[] input = new int[] {2,0,2,1,1,0};
        int[] expected = new int[] {0,0,1,1,2,2};

        runSolution(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void two() {
        int[] input = new int[] {2,1,2,1,2,1};
        int[] expected = new int[] {1,1,1,2,2,2};

        runSolution(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void three() {
        int[] input = new int[] {2,0,1};
        int[] expected = new int[] {0,1,2};

        runSolution(input);
        assertArrayEquals(expected, input);
    }

}