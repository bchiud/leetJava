package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidAnagramTest {

    private static boolean runSolution(String s, String t) {
        // return ValidAnagram.isAnagramSort(s, t);
        return ValidAnagram.isAnagramHashTableArray(s, t);
    }

    @Test
    void one() {
        String s = "anagram";
        String t = "nagaram";

        assertEquals(true, runSolution(s, t));
    }

    @Test
    void two() {
        String s = "rat";
        String t = "car";

        assertEquals(false, runSolution(s, t));
    }

}