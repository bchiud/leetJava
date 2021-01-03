package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    private static void runSolution(int[] nums, int k) {
        RotateArray.rotate(nums, k);
    }

    @Test
    void one() {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        runSolution(nums, k);

        int[] expected = new int[] {5,6,7,1,2,3,4};
        assertArrayEquals(expected, nums);
    }

    @Test
    void two() {
        int[] nums = new int[] {-1,-100,3,99};
        int k = 2;
        runSolution(nums, k);

        int[] expected = new int[] {3,99,-1,-100};
        assertArrayEquals(expected, nums);
    }

    @Test
    void three() {
        int[] nums = new int[] {1};
        int k = 0;
        runSolution(nums, k);

        int[] expected = new int[] {1};
        assertArrayEquals(expected, nums);
    }

}