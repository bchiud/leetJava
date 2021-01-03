package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    private static void runSolution(int[] nums) {
        MoveZeroes.moveZeroes(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {0,1,0,3,12};
        int[] expected = new int[] {1,3,12,0,0};
        runSolution(nums);
        assertArrayEquals(expected, nums);
    }


    @Test
    void two() {
        int[] nums = new int[] {1,0,1,0,0,0};
        int[] expected = new int[] {1,1,0,0,0,0};
        runSolution(nums);
        assertArrayEquals(expected, nums);
    }

}