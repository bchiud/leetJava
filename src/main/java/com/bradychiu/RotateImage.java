package com.bradychiu;

public class RotateImage {
    /**
     * time: n^2
     * space: 1
     */
    public static void rotateTransposeHoriztonalReverse(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < r; c++) {
                swap(matrix, r, c, c, r);
            }
        }

        // horizontal reverse
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                swap(matrix, r, c, r, n - c - 1);
            }
        }
    }

    private static void swap(int[][] matrix, int ax, int ay, int bx, int by) {
        int tmp = matrix[ax][ay];
        matrix[ax][ay] = matrix[bx][by];
        matrix[bx][by] = tmp;
    }


    /**
     * 00 -> 03
     * 03 -> 33
     * 33 -> 30
     * 30 -> 00
     * <p>
     * n = 4
     * 01 -> 13 ab -> bc    a = 0   a = n - c - 1   a = i
     * 13 -> 32 bc -> cd    b = 1   b = n - d - 1   b = j
     * 32 -> 20 cd -> da    c = 3   c = n - a - 1   c = n - i - 1
     * 20 -> 01 da -> ab    d = 2   d = n - b - 1   d = n - j - 1
     * <p>
     * 02 -> 23
     * 23 -> 31
     * 31 -> 10
     * 10 -> 02
     * <p>
     * 11 -> 12
     * 12 -> 22
     * 22 -> 21
     * 21 -> 11
     *
     * 4x4 ij: 00, 01, 02, 11
     * 5x5 ij: 00, 01, 02, 03, 11, 12
     * 0 <= i < (n + 1) / 2
     * i <= j < n - i - 1
     *
     *
     * time: n^2
     * space: 1
     */

    public static void rotateImageOnePass(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                System.out.println("i: " + i + "; j: " + j);
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
