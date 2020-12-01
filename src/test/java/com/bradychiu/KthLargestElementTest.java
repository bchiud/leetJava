package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementTest {

    private static int runSolution(int[] nums, int k) {
        // return KthLargestElement.findKthLargestMinHeap(nums, k);
        return KthLargestElement.findKithLargestMergeSort(nums, k);
        // return KthLargestElement.findKthLargestQuickSort(nums, k);
    }

    @Test
    void one() {
        int[] input = new int[] {3,2,1,5,6,4};
        int k = 2;
        int expected = 5;

        assertEquals(expected, runSolution(input, k));
    }

    @Test
    void two() {
        int[] input = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int expected = 4;

        assertEquals(expected, runSolution(input, 4));
    }

}