package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseStringTest {

    private static void runSolution(char[] s) {
        ReverseString.reverseString(s);
    }

    @Test
    void one() {
        char[] s = new char[] {'h','e','l','l','o'};
        char[] expected = new char[] {'o','l','l','e','h'};

        runSolution(s);
        assertArrayEquals(expected, s);
    }

    @Test
    void two() {
        char[] s = new char[] {'H','a','n','n','a','h'};
        char[] expected = new char[] {'h','a','n','n','a','H'};

        runSolution(s);
        assertArrayEquals(expected, s);
    }

}