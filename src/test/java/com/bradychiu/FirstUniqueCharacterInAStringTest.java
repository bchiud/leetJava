package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueCharacterInAStringTest {

    private static int runSolution(String s) {
        // return FirstUniqueCharacterInAString.firstUniqCharHashMap(s);
        return FirstUniqueCharacterInAString.firstUniqCharHashMap(s);
    }

    @Test
    void one() {
        String s = "leetcode";
        assertEquals(0, runSolution(s));
    }

    @Test
    void two() {
        String s = "loveleetcode";
        assertEquals(2, runSolution(s));
    }

}