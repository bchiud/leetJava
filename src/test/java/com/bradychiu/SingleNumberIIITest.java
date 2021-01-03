package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberIIITest {

    private static int[] runSolution(int[] nums) {
        // return SingleNumberIII.singleNumbersSet(nums);
        return SingleNumberIII.singleNumberBitmaks(nums);
    }

    @Test
    void one() {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] expected1 = new int[]{3, 5};
        int[] expected2 = new int[]{5, 3};
        assertTrue(Arrays.equals(expected1, runSolution(nums))
                || Arrays.equals(expected2, runSolution(nums)));
    }

    @Test
    void two() {
        int[] nums = new int[]{-1, 0};
        int[] expected1 = new int[]{-1, 0};
        int[] expected2 = new int[]{0, -1};

        assertTrue(Arrays.equals(expected1, runSolution(nums))
                || Arrays.equals(expected2, runSolution(nums)));
    }

    @Test
    void three() {
        int[] nums = new int[]{0, 1};
        int[] expected1 = new int[]{0, 1};
        int[] expected2 = new int[]{1, 0};

        assertTrue(Arrays.equals(expected1, runSolution(nums))
                || Arrays.equals(expected2, runSolution(nums)));
    }

}