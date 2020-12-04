package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    private static int runSolution(int[] nums) {
        // return LongestIncreasingSubsequence.lengthOfLISDp(nums);
        return LongestIncreasingSubsequence.lengthOfLISDpBinarySearch(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        int expected = 4;

        assertEquals(expected, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {0,1,0,3,2,3};
        int expected = 4;

        assertEquals(expected, runSolution(nums));
    }

    @Test
    void three() {
        int[] nums = new int[] {7,7,7,7,7,7,7};
        int expected = 1;

        assertEquals(expected, runSolution(nums));
    }

    @Test
    void four() {
        int[] nums = new int[] {0,2,1,4,3};
        int expected = 3;

        assertEquals(expected, runSolution(nums));
    }

}