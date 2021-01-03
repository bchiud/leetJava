package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {
    @Test
    void one() {
        int input = 123;
        int expected = 321;

        assertEquals(expected, ReverseInteger.reverse(input));
    }

    @Test
    void two() {
        int input = -123;
        int expected = -321;

        assertEquals(expected, ReverseInteger.reverse(input));
    }

    @Test
    void three() {
        int input = 120;
        int expected = 21;

        assertEquals(expected, ReverseInteger.reverse(input));
    }

    @Test
    void four() {
        int input = 0;
        int expected = 0;

        assertEquals(expected, ReverseInteger.reverse(input));
    }

    @Test
    void five() {
        int input = Integer.MAX_VALUE;
        int expected = 0;

        assertEquals(expected, ReverseInteger.reverse(input));
    }

    @Test
    void six() {
        int input = Integer.MIN_VALUE;
        int expected = 0;

        assertEquals(expected, ReverseInteger.reverse(input));
    }
}