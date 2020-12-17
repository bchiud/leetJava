package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {

    private int runSolution(String[] tokens) {
        return EvaluateReversePolishNotation.evalRPN(tokens);
    }

    @Test
    void one() {
        String[] input = new String[]{"2", "1", "+", "3", "*"};
        assertEquals(9, runSolution(input));
    }

    @Test
    void two() {
        String[] input = new String[]{"4", "13", "5", "/", "+"};
        assertEquals(6, runSolution(input));
    }

    @Test
    void three() {
        String[] input = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, runSolution(input));
    }

}