package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRangeTest {

    private static int[] runSolution(int[] nums, int target) {
        // return SearchRange.searchRangeBinaryRecursive(nums, target);
        return SearchRange.searchRangeBinaryIterative(nums, target);
    }

    @Test
    void one() {
        int[] input = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = new int[]{3, 4};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void two() {
        int[] input = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = new int[]{-1, 1};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void three() {
        int[] input = new int[]{};
        int target = 0;
        int[] expected = new int[]{-1, 1};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void four() {
        int[] input = new int[]{5, 7, 7, 8, 8, 10, (int) Math.pow(10, 9)};
        int target = (int) Math.pow(10, 9);
        int[] expected = new int[]{6, 6};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void five() {
        int[] input = new int[]{1, 1, 1, 2, 2, 2};
        int target = 1;
        int[] expected = new int[]{0, 2};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void six() {
        int[] input = new int[]{1, 1, 1, 2, 2, 2};
        int target = 2;
        int[] expected = new int[]{3, 5};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void seven() {
        int[] input = new int[]{1, 1, 1, 1, 1, 1};
        int target = 1;
        int[] expected = new int[]{0, 5};

        assertArrayEquals(expected, runSolution(input, target));
    }

    @Test
    void eight() {
        int[] input = new int[]{2, 2, 2};
        int target = 3;
        int[] expected = new int[]{-1, 1};

        assertArrayEquals(expected, runSolution(input, target));
    }

}