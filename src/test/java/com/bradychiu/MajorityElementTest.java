package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    private static int runSolution(int[] nums) {
        // return MajorityElement.majorityElementHashMap(nums);
        // return MajorityElement.majorityElementQuickSort(nums);
        return MajorityElement.majorityElementBoyerMooreVotingAlgo(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {3,2,3};
        assertEquals(3, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        assertEquals(2, runSolution(nums));
    }

}