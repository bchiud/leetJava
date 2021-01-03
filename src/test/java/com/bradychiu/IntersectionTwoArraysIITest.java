package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionTwoArraysIITest {

    private static int[] runSolution(int[] nums1, int[] nums2) {
        // return IntersectionTwoArraysII.intersectHashMap(nums1, nums2);
        return IntersectionTwoArraysII.intersectQuickSort(nums1, nums2);
        // return IntersectionTwoArraysII.intersectMergeSort(nums1, nums2);
    }

    @Test
    void one() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] expected = new int[]{2, 2};

        assertArrayEquals(expected, runSolution(nums1, nums2));
    }

    void two() {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] expected = new int[]{4, 9};

        assertArrayEquals(expected, runSolution(nums1, nums2));
    }

}