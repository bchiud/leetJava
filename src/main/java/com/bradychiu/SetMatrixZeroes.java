package com.bradychiu;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int col0 = 1;

        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0)
                col0 = 0;

            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = matrix.length - 1; r >= 0 ; r--) {
            for (int c = matrix[r].length - 1; c >= 1; c--) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                    matrix[r][c] = 0;
            }

            if (col0 == 0)
                matrix[r][0] = 0;
        }
    }
}
