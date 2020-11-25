package com.bradychiu;

public class WordSearch {

    /**
     * k = word.length();
     * time: (n*m) * 4^k
     * space: 1
     */
    public static boolean exist(char[][] board, String word) {
        for (int h = 0; h < board.length; h++)
            for (int v = 0; v < board[h].length; v++)
                if (board[h][v] == word.charAt(0) && search(board, word, 0, h, v))
                    return true;

        return false;
    }

    private static boolean search(char[][] board, String word, int pos, int h, int v) {
        if (pos == word.length())
            return true;

        if (h < 0 || h >= board.length || v < 0 || v >= board[h].length || board[h][v] != word.charAt(pos))
            return false;


        char tmp = board[h][v];
        board[h][v] = ' ';

        // System.out.println("h: " + h + "; v: " + v + "; c: " + word.charAt(pos));

        boolean found = search(board, word, pos + 1, h - 1, v)
                || search(board, word, pos + 1, h + 1, v)
                || search(board, word, pos + 1, h, v - 1)
                || search(board, word, pos + 1, h, v + 1);

        board[h][v] = tmp;
        return found;
    }
}
