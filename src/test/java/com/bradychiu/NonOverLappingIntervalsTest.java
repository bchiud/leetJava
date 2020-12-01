package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonOverLappingIntervalsTest {

    private static int runSolution(int[][] intervals) {
        return NonOverLappingIntervals.eraseOverlapIntervalsMinHeap(intervals);
    }

    @Test
    void one() {
        int[][] input = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int expected = 1;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void two() {
        int[][] input = new int[][]{{1, 2}, {1,2}, {1,2}};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }

}