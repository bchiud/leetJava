package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImplementStrStrTest {

    private static int runSolution(String haystack, String needle) {
        return ImplementStrStr.strStr(haystack, needle);
    }

    @Test
    void one() {
        String haystack = "hello";
        String needle = "ll";

        assertEquals(2, runSolution(haystack, needle));
    }

    @Test
    void two() {
        String haystack = "aaaaa";
        String needle = "bba";

        assertEquals(-1, runSolution(haystack, needle));
    }

    @Test
    void three() {
        String haystack = "";
        String needle = "";

        assertEquals(0, runSolution(haystack, needle));
    }

    @Test
    void four() {
        String haystack = "a";
        String needle = "";

        assertEquals(0, runSolution(haystack, needle));
    }
}