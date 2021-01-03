package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private static int[] runSolution(int[] nums, int target) {
        // return TwoSum.twoSumBrute(nums, target);
        return TwoSum.twoSumHashing(nums, target);
    }

    @Test
    void one() {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        int[] expected = new int[] {0,1};

        assertArrayEquals(expected, runSolution(nums, target));
    }

    @Test
    void two() {
        int[] nums = new int[] {3,2,4};
        int target = 6;
        int[] expected = new int[] {1,2};

        assertArrayEquals(expected, runSolution(nums, target));
    }

    @Test
    void three() {
        int[] nums = new int[] {3,3};
        int target = 6;
        int[] expected = new int[] {0,1};

        assertArrayEquals(expected, runSolution(nums, target));
    }
}