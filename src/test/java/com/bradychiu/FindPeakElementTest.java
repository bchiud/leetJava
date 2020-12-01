package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPeakElementTest {

    private static int runSolution(int[] nums) {
        // return FindPeakElement.findPeakElementSequential(nums);
        // return FindPeakElement.findPeakElementBinarySearchRecursive(nums);
        return FindPeakElement.findPeakElementBinarySearchIterative(nums);
    }

    @Test
    void one() {
        int[] input = new int[] {1,2,3,1};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void two() {
        int[] input = new int[] {1,2,1,3,5,6,4};
        List<Integer> expected = Arrays.asList(1,5);

        assert expected.contains(runSolution(input));
    }

    @Test
    void three() {
        int[] input = new int[] {1};
        int expected = 0;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void four() {
        int[] input = new int[] {1,2};
        int expected = 1;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void five() {
        int[] input = new int[] {2,1};
        int expected = 0;

        assertEquals(expected, runSolution(input));
    }
}