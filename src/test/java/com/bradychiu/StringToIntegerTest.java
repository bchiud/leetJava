package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToIntegerTest {

    private static int runSolution(String s) {
        return StringToInteger.myAtoi(s);
    }

    @Test
    void one() {
        String s = "   -42";
        assertEquals(-42, runSolution(s));
    }

    @Test
    void two() {
        String s = "4193 with words";
        assertEquals(4193, runSolution(s));
    }

    @Test
    void three() {
        String s = "words and 987";
        assertEquals(0, runSolution(s));
    }

    @Test
    void four() {
        String s = "-91283472332";
        assertEquals(Integer.MIN_VALUE, runSolution(s));
    }

    @Test
    void five() {
        String s = " ";
        assertEquals(0, runSolution(s));
    }

    @Test
    void six() {
        String s = "-2147483647";
        assertEquals(-2147483647, runSolution(s));
    }

    @Test
    void seven() {
        String s = "-2147483648";
        assertEquals(Integer.MIN_VALUE, runSolution(s));
    }
}