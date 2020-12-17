package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    private static int runSolution(int x) {
        return Sqrt.mySqrtBinary(x);
    }

    @Test
    void one() {
        assertEquals(2, runSolution(4));
    }

    @Test
    void two() {
        assertEquals(2, runSolution(8));
    }

}