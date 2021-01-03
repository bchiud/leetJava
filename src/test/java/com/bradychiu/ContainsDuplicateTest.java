package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    private static boolean runSolution(int[] nums) {
        // return ContainsDuplicate.containsDuplicateLinear(nums);
        return ContainsDuplicate.containsDuplicateSort(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {1,2,3,1};
        assertEquals(true, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {1,2,3,4};
        assertEquals(false, runSolution(nums));
    }

    @Test
    void three() {
        int[] nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        assertEquals(true, runSolution(nums));
    }

}