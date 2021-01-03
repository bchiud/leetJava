package com.bradychiu;

public class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int topLeftToBottomRight;
    private int topRightToBottomLeft;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        topLeftToBottomRight = 0;
        topRightToBottomLeft = 0;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     * <p>
     * time: 1
     * space: n
     */
    public int move(int row, int col, int player) {
        // player 1 ==> +1; player 2 ==> -1;
        rows[row] += player == 1 ? 1 : -1;
        cols[col] += player == 1 ? 1 : -1;
        if (row == col)
            topLeftToBottomRight += player == 1 ? 1 : -1;
        if (row + col == rows.length - 1)
            topRightToBottomLeft += player == 1 ? 1 : -1;

        if (rows[row] == rows.length
                || cols[col] == cols.length
                || topLeftToBottomRight == rows.length
                || topRightToBottomLeft == rows.length)
            return 1;

        if (rows[row] == -rows.length
                || cols[col] == -cols.length
                || topLeftToBottomRight == -rows.length
                || topRightToBottomLeft == -rows.length)
            return 2;

        return 0;
    }


    // private final int GAME_STILL_IN_PROGRESS = 0;
    // private final int BOARD_SIZE;
    // private int[][] board;
    //
    // /**
    //  * Initialize your data structure here.
    //  */
    // public com.bradychiu.TwoSum.TicTacToe(int n) {
    //     BOARD_SIZE = n;
    //     board = new int[BOARD_SIZE][BOARD_SIZE];
    // }
    //
    // /**
    //  * Player {player} makes a move at ({row}, {col}).
    //  *
    //  * @param row    The row of the board.
    //  * @param col    The column of the board.
    //  * @param player The player, can be either 1 or 2.
    //  * @return The current winning condition, can be either:
    //  * 0: No one wins.
    //  * 1: Player 1 wins.
    //  * 2: Player 2 wins.
    //  * <p>
    //  * time: 4n
    //  * space: n^2
    //  */
    // public int move(int row, int col, int player) {
    //     board[row][col] = player;
    //
    //     if (chkRow(row, player) || chkCol(col, player))
    //         return player;
    //
    //     if (row == col && chkLeftDiag(row, col, player))
    //         return player;
    //
    //     if (row + col == BOARD_SIZE - 1 && chkRightDiag(row, col, player))
    //         return player;
    //
    //     return GAME_STILL_IN_PROGRESS;
    // }
    //
    // private boolean chkRow(int row, int player) {
    //     for (int col = 0; col < BOARD_SIZE; col++)
    //         if (board[row][col] != player)
    //             return false;
    //
    //     return true;
    // }
    //
    // private boolean chkCol(int col, int player) {
    //     for (int row = 0; row < BOARD_SIZE; row++)
    //         if (board[row][col] != player)
    //             return false;
    //
    //     return true;
    // }
    //
    //
    // private boolean chkLeftDiag(int row, int col, int player) {
    //     for (int i = 0; i < BOARD_SIZE; i++)
    //         if (board[i][i] != player)
    //             return false;
    //
    //     return true;
    // }
    //
    // private boolean chkRightDiag(int row, int col, int player) {
    //     for (int i = 0; i < BOARD_SIZE; i++)
    //         if (board[i][BOARD_SIZE - 1 - i] != player)
    //             return false;
    //
    //     return true;
    // }

}
