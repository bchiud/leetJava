package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RotateImageTest {

    private static void runSolution(int[][] matrix) {
        // RotateImage.rotateTransposeHoriztonalReverse(matrix);
        RotateImage.rotateImageOnePass(matrix);
    }

    @Test
    void one() {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expected = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        runSolution(matrix);
        assertTrue(arrayOfArrayEquals(expected, matrix));
    }

    @Test
    void two() {
        int[][] matrix = new int[][]{
                {1}
        };
        int[][] expected = new int[][]{
                {1}
        };
        runSolution(matrix);
        assertTrue(arrayOfArrayEquals(expected, matrix));
    }

    @Test
    void three() {
        int[][] matrix = new int[][]{
                {1, 2},
                {3, 4}
        };
        int[][] expected = new int[][]{
                {3, 1},
                {4, 2}
        };
        runSolution(matrix);
        assertTrue(arrayOfArrayEquals(expected, matrix));
    }

    @Test
    void four() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        runSolution(matrix);
        assertTrue(arrayOfArrayEquals(expected, matrix));
    }

    @Test
    void five() {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expected = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        runSolution(matrix);
        assertTrue(arrayOfArrayEquals(expected, matrix));
    }

    @Test
    void six() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        int[][] expected = new int[][]{
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 4},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5}
        };
        runSolution(matrix);
        assertTrue(arrayOfArrayEquals(expected, matrix));
    }

    private static boolean arrayOfArrayEquals(int[][] expected, int[][] actual) {
        if (expected.length != actual.length)
            return false;

        if (expected[0].length != actual[0].length)
            return false;

        for (int r = 0; r < expected.length; r++) {
            for (int c = 0; c < expected.length; c++) {
                if (expected[r][c] != actual[r][c])
                    return false;
            }
        }

        return true;
    }

}