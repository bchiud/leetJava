package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    private static boolean runSolution(int[] nums) {
        // return JumpGame.canJumpBacktracking(nums);
        // return JumpGame.canJumpDPBotUp(nums);
        return JumpGame.canJumpDPGreedy(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {2,3,1,1,4};
        boolean expected = true;

        assertEquals(expected, runSolution(nums));
    }

    @Test
    void two() {
        int[] nums = new int[] {3,2,1,0,4};
        boolean expected = false;

        assertEquals(expected, runSolution(nums));
    }

    @Test
    void three() {
        int[] nums = new int[] {1};
        boolean expected = true;

        assertEquals(expected, runSolution(nums));
    }
}