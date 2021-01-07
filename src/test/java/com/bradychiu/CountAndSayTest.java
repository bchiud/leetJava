package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountAndSayTest {

    private static String runSolution(int n) {
        // return CountAndSay.countAndSaySlidingWindowPointers(n);
        // return CountAndSay.countAndSaySlidingWindowStringBuilder(n);
        return CountAndSay.countAndSayRecursive(n);
    }

    @Test
    void one() {
        int n = 1;
        String expected = "1";

        assertEquals(expected, runSolution(n));
    }

    @Test
    void two() {
        int n = 4;
        String expected = "1211";

        assertEquals(expected, runSolution(n));
    }
}