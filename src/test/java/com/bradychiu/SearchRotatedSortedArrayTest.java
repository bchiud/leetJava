package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRotatedSortedArrayTest {

    private static int runSolution(int[] nums, int target) {
        // return SearchRotatedSortedArray.searchBinaryRecursive(nums, target);
        return SearchRotatedSortedArray.searchBinaryIterative(nums, target);
    }

    @Test
    void one() {
        int[] input = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        int expected = 4;

        assertEquals(expected, runSolution(input, target));
    }

    @Test
    void two() {
        int[] input = new int[] {4,5,6,7,0,1,2};
        int target = 3;
        int expected = -1;

        assertEquals(expected, runSolution(input, target));
    }

    @Test
    void three() {
        int[] input = new int[] {1};
        int target = 0;
        int expected = -1;

        assertEquals(expected, runSolution(input, target));
    }

    @Test
    void four() {
        int[] input = new int[] {5,1,3};
        int target = 3;
        int expected = 2;

        assertEquals(expected, runSolution(input, target));
    }

}