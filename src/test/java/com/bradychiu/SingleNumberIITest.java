package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberIITest {

    private static int runSolution(int[] nums) {
        // return SingleNumberII.singleNumberSet(nums);
        // return SingleNumberII.singleNumberHashMap(nums);
        return SingleNumberII.singleNumberBitwise(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {2,2,3,2};
        assertEquals(3, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {0,1,0,1,0,1,99};
        assertEquals(99, runSolution(nums));
    }

}