package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateIIITest {

    private static boolean runSolution(int[] nums, int k, int t) {
        // return ContainsDuplicateIII.containsNearbyAlmostDuplicateBST(nums, k, t);
        return ContainsDuplicateIII.containsNearbyAlmostDuplicateBuckets(nums, k, t);
    }

    @Test
    void one() {
        int[] nums = new int[] {-2147483648,2147483647};
        assertEquals(false, runSolution(nums, 1, 1));
    }

    @Test
    void two() {
        int[] nums = new int[] {1,5,9,1,5,9};
        assertEquals(false, runSolution(nums, 2, 3));
    }

    @Test
    void three() {
        int[] nums = new int[] {2147483640,2147483641};
        assertEquals(true, runSolution(nums, 1, 100));
    }

}