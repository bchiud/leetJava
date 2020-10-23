package com.bradychiu;

import org.junit.jupiter.api.Test;

import static com.bradychiu.SetMatrixZeroes.setZeroes;
import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroesTest {

    @Test
    void one() {
        int[][] input = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        setZeroes(input);

        assertArrayEquals(input, expected);
    }

    @Test
    void two() {
        int[][] input = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] expected = new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}};
        setZeroes(input);

        assertArrayEquals(input, expected);
    }
}