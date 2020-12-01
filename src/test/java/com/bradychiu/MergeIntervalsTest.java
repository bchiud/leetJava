package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    private static int[][] runSolution(int[][] intervals) {
        return MergeIntervals.merge(intervals);
    }

    @Test
    void one() {
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
    }

    @Test
    void two() {
        int[][] input = new int[][]{{1, 4}, {4, 5}};
        int[][] expected = new int[][]{{1, 5}};
    }

}