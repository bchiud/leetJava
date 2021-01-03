package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPalindromeTest {

    private static boolean runSolution(String s) {
        // return ValidPalindrome.isPalindromeRegex(s);
        return ValidPalindrome.isPalindromeFaster(s);
    }

    @Test
    void one() {
        String input = "A man, a plan, a canal: Panama";
        assertEquals(true, runSolution(input));
    }

    @Test
    void two() {
        String input = "race a car";
        assertEquals(false, runSolution(input));
    }

    @Test
    void three() {
        String input = "0P";
        assertEquals(false, runSolution(input));
    }


}