package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void one() {
        String input = "babad";
        String expected = "bab";
        String alternateExpected = "aba";
        assert(LongestPalindrome.longestPalindrome(input).equals(expected)
                || LongestPalindrome.longestPalindrome(input).equals(alternateExpected));
    }

    @Test
    void two() {
        String input = "cbbd";
        String expected = "bb";
        assertEquals(expected, LongestPalindrome.longestPalindrome(input));
    }

    @Test
    void three() {
        String input = "a";
        String expected = "a";
        assertEquals(expected, LongestPalindrome.longestPalindrome(input));
    }

    @Test
    void four() {
        String input = "ac";
        String expected = "a";
        String alternateExpected = "c";
        assert(LongestPalindrome.longestPalindrome(input).equals(expected)
                || LongestPalindrome.longestPalindrome(input).equals(alternateExpected));
    }
}