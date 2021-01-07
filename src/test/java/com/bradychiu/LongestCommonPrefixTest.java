package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    private static String runSolution(String[] strs) {
        // return LongestCommonPrefix.longestCommonPrefixVerticalScan(strs);
        return LongestCommonPrefix.longestCommonPrefixHorizontalScan(strs);
    }

    @Test
    void one() {
        String[] strs = new String[] {"flower","flow","flight"};
        assertEquals("fl", runSolution(strs));
    }

    @Test
    void two() {
        String[] strs = new String[] {"dog","racecar","car"};
        assertEquals("", runSolution(strs));
    }

    @Test
    void three() {
        String[] strs = new String[] {"", "b"};
        assertEquals("", runSolution(strs));
    }

    @Test
    void four() {
        String[] strs = new String[] {"ab", "a"};
        assertEquals("a", runSolution(strs));
    }

    @Test
    void five() {
        String[] strs = new String[] {"aaa","aa","aaa"};
        assertEquals("aa", runSolution(strs));
    }

}