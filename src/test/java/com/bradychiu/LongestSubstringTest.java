package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {
    @Test
    void one() {
        String input = "abcabcbb";
        int expected = 3;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void two() {
        String input = "bbbbb";
        int expected = 1;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void three() {
        String input = "pwwkew";
        int expected = 3;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void four() {
        String input = "";
        int expected = 0;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void five() {
        String input = "a";
        int expected = 1;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void six() {
        String input = "     ";
        int expected = 1;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void seven() {
        String input = "aab";
        int expected = 2;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void eight() {
        String input = "dvdf";
        int expected = 3;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }

    @Test
    void nine() {
        String input = "abba";
        int expected = 2;
        assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(input));
    }
}