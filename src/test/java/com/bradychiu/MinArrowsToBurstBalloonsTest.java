package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinArrowsToBurstBalloonsTest {

    private static int runSolution(int[][] points) {
        return MinArrowsToBurstBalloons.findMinArrowShots(points);
    }

    @Test
    void one() {
        int[][] input = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void two() {
        int[][] input = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int expected = 4;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void three() {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void four() {
        int[][] input = {{1, 2}};
        int expected = 1;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void five() {
        int[][] input = {{2, 3}, {2, 3}};
        int expected = 1;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void six() {
        int[][] input = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }

}