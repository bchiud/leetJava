package com.bradychiu;

public class Search2dMatrixII {

    /**
     * time: n*m
     * space: 1
     */

    public static boolean searchMatrixBrute(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || matrix[rows][cols] < target)
            return false;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == target)
                    return true;
            }
        }

        return false;
    }

    /**
     * time: n*log(n)
     * space: log(n) -> log(n) recursions with each taking constant space
     */

    public static boolean searchMatrixDivideAndConquer(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || matrix[rows - 1][cols - 1] < target)
            return false;

        return divideAndConquerHelper(matrix, target, 0, 0, cols - 1, rows - 1);
    }

    private static boolean divideAndConquerHelper(int[][] matrix, int target, int l, int t, int r, int b) {
        if (l > r || t > b)
            return false;
        if (target < matrix[t][l] || matrix[b][r] < target)
            return false;

        // divide  matrix into 4
        // target can only be in bot left or top right sub-matrix
        int mid = l + (r - l) / 2;
        int row = t;
        while (row < b && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target)
                return true;
            row++;
        }

        return divideAndConquerHelper(matrix, target, l, row, mid - 1, b)
                || divideAndConquerHelper(matrix, target, mid + 1, t, r, row - 1);
    }


    /**
     * time: m + n
     * space: 1
     */

    public static boolean searchMatrixReduced(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        // bot left (or top right) gives a position where one direction moves up while another moves down
        // bot right and top left aren't feasible -> uncertain which direction to move
        // bot right has two moves, both of which go down in value
        // top left has tow moves, both of which go up in value
        int rowIndex = matrix.length - 1;
        int colIndex = 0;

        while (rowIndex >= 0 && colIndex < matrix[rowIndex].length) {
            if (matrix[rowIndex][colIndex] > target) {
                rowIndex--;
            } else if (matrix[rowIndex][colIndex] < target) {
                colIndex++;
            } else {
                return true;
            }
        }

        return false;
    }
}
