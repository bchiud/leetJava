package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {

    @Test
    void one() {
        assertEquals(3, SumOfTwoIntegers.getSum(1,2));
    }

    @Test
    void two() {
        assertEquals(4, SumOfTwoIntegers.getSum(1,3));
    }

    @Test
    void three() {
        assertEquals(0, SumOfTwoIntegers.getSum(-1,1));
    }

    @Test
    void four() {
        assertEquals(-2, SumOfTwoIntegers.getSum(-1,-1));
    }

}