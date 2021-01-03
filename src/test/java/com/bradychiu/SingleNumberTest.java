package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    private static int runSolution(int[] nums) {
        // return SingleNumber.singleNumberSet(nums);
        // return SingleNumber.singleNumberMath(nums);
        return SingleNumber.singleNumberBitManipulation(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {2,2,1};
        assertEquals(1, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {4,1,2,1,2};
        assertEquals(4, runSolution(nums));
    }

    @Test
    void three() {
        int[] nums = new int[] {1};
        assertEquals(1, runSolution(nums));
    }

}