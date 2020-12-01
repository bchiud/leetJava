package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2dMatrixIITest {

    private static boolean runSolution(int[][] matrix, int target) {
        // return Search2dMatrixII.searchMatrixBrute(matrix, target);
        return Search2dMatrixII.searchMatrixDivideAndConquer(matrix, target);
        // return Search2dMatrixII.searchMatrixReduced(matrix, target);
    }

    @Test
    void one() {
        int[][] input = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 16;
        boolean expected = true;

        assertEquals(expected, runSolution(input, target));
    }

    @Test
    void two() {
        int[][] input = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 20;
        boolean expected = false;

        assertEquals(expected, runSolution(input, target));
    }

}