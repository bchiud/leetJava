package com.bradychiu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class TwoSumTest {

    private static int[] integersOne;
    private static int targetOne;
    private static int[] expectedOne;

    @BeforeAll
    static void init() {
        integersOne = new int[]{2, 7, 11, 15};
        targetOne = 9;
        expectedOne = new int[]{0, 1};
    }

    @Test
    void twoSumBrute() {
        int[] result = TwoSum.twoSumBrute(integersOne, targetOne);
        Arrays.sort(result);
        assertArrayEquals(expectedOne, result);
    }

    @Test
    void twoSumHashing() {
        int[] result = TwoSum.twoSumHashing(integersOne, targetOne);
        Arrays.sort(result);
        assertArrayEquals(expectedOne, result);
    }

    @Test
    void twoSumSortedBinarySearch() {
        assertArrayEquals(expectedOne, TwoSum.twoSumSortedBinarySearch(integersOne, targetOne));
    }

    @Test
    void twoSumSortedPointers() {
        assertArrayEquals(expectedOne, TwoSum.twoSumSortedPointers(integersOne, targetOne));
    }
}