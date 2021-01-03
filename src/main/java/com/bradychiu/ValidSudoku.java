package com.bradychiu;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /**
     * time: n
     * space: n
     */
    public boolean isValidSudokuSet(char[][] board) {
        assert board.length == board[0].length;

        int n = board.length;
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] cols = new HashSet[n];
        Set<Integer>[] boxs = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.')
                    continue;

                int num = Integer.valueOf(board[r][c] - '0');
                if (!rows[c].add(num)
                        || !cols[r].add(num)
                        || !boxs[(r / 3) * 3 + (c / 3)].add(num))
                    return false;

            }
        }

        return true;
    }

    /**
     * time: n
     * space: n
     */
    public boolean isValidSudokuArray(char[][] board) {
        assert board.length == board[0].length;

        int n = board.length;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] boxs = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.')
                    continue;

                int b = (r / 3) * 3 + (c / 3);
                int num = Integer.valueOf(board[r][c] - '0' - 1);
                if (rows[r][num] || cols[c][num] || boxs[b][num])
                    return false;

                rows[r][num] = true;
                cols[c][num] = true;
                boxs[b][num] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char c = '0';
        System.out.println(Integer.valueOf(c - '0'));
    }
}
