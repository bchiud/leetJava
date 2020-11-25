package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    private static int[] runSolution(int[] nums, int k) {
        return TopKFrequentElements.topKFrequentTreeMap(nums, k);
        // return TopKFrequentElements.topKFrequentHeap(nums, k);
        // return TopKFrequentElements.topKFrequentBucketSort(nums, k);
    }

    @Test
    void one() {
        int[] input = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = new int[]{1, 2};
        int[] output = runSolution(input, k);
        Arrays.sort(output);

        assertArrayEquals(expected, output);
    }

    @Test
    void two() {
        int[] input = new int[]{1};
        int k = 1;
        int[] expected = new int[]{1};
        int[] output = runSolution(input, k);
        Arrays.sort(output);

        assertArrayEquals(expected, output);
    }

}