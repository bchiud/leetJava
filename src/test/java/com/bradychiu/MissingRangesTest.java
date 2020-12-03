package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MissingRangesTest {

    private static List<String> runSolution(int[] nums, int lower, int upper) {
        return MissingRanges.findMissingRanges(nums, lower, upper);
    }

    @Test
    void one() {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> expected = Arrays.asList("2","4->49","51->74","76->99");

        assertEquals(expected, runSolution(nums, lower, upper));
    }

    @Test
    void two() {
        int[] nums = new int[]{};
        int lower = 1;
        int upper = 1;
        List<String> expected = Arrays.asList("1");

        assertEquals(expected, runSolution(nums, lower, upper));
    }

    @Test
    void three() {
        int[] nums = new int[]{};
        int lower = -3;
        int upper = -1;
        List<String> expected = Arrays.asList("-3->-1");

        assertEquals(expected, runSolution(nums, lower, upper));
    }

    @Test
    void four() {
        int[] nums = new int[]{-1};
        int lower = -1;
        int upper = -1;
        List<String> expected = Arrays.asList();

        assertEquals(expected, runSolution(nums, lower, upper));
    }

    @Test
    void five() {
        int[] nums = new int[]{-1};
        int lower = -2;
        int upper = -1;
        List<String> expected = Arrays.asList("-2");

        assertEquals(expected, runSolution(nums, lower, upper));
    }




}