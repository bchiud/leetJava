package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    @Test
    void one() {
        char[][] grid = {
                {'0', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        assertEquals(1, NumberOfIslands.numIslands(grid));
    }

    @Test
    void two() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        assertEquals(3, NumberOfIslands.numIslands(grid));
    }
    
    @Test
    void three() {
        char[][] grid = {
                {'1','0','1','1','0','1','1'}
        };

        assertEquals(3, NumberOfIslands.numIslands(grid));
    }
}