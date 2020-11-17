package com.bradychiu;

public class NumberOfIslands {

    // time: n*m
    // space: 1
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int islands = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                islands += sinkIsland(grid, i, j);

        return islands;
    }

    private static int sinkIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;

        grid[i][j] = '0';
        sinkIsland(grid, i + 1, j);
        sinkIsland(grid, i - 1, j);
        sinkIsland(grid, i, j + 1);
        sinkIsland(grid, i, j - 1);

        return 1;
    }
}
