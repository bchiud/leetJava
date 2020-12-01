package com.bradychiu.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionTest {

    @Test
    void one() {
        Integer[] input = new Integer[]{6, 3, 5, 1, 4, 2};
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6};

        Selection.sort(input);
        assertArrayEquals(expected, input);
    }
}