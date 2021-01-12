package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

    private static void runSolution(int[] nums1, int m, int[] nums2, int n) {
        MergeSortedArray.merge(nums1, m, nums2, n);
    }

    @Test
    void one() {
        int[] nums1 = new int[] {1,3,5,7,9,0,0,0,0,0};
        int[] nums2 = new int[] {2,4,6,8,10};
        int[] expected = new int[] {1,2,3,4,5,6,7,8,9,10};

        runSolution(nums1, 5, nums2, 5);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void two() {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        int[] expected = new int[] {1,2,2,3,5,6};

        runSolution(nums1, 3, nums2, 3);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void three() {
        int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {};
        int[] expected = new int[] {1};

        runSolution(nums1, 1, nums2, 0);
        assertArrayEquals(expected, nums1);
    }

}