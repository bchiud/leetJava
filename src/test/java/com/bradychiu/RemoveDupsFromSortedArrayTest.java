package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDupsFromSortedArrayTest {

    private static int runSolution(int[] nums) {
        return RemoveDupsFromSortedArray.removeDuplicates(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {1,1,2};
        int expected = 2;

        assertEquals(expected, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int expected = 5;

        assertEquals(expected, runSolution(nums));
    }

}