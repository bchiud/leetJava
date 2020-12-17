package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionToRecurringDecimalTest {

    @Test
    void one() {
        assertEquals("0.(3)", FractionToRecurringDecimal.factionToDecimal(1, 3));
    }

    @Test
    void two() {
        assertEquals("0.1(6)", FractionToRecurringDecimal.factionToDecimal(1, 6));
    }

    @Test
    void three() {
        assertEquals("0.0(45)", FractionToRecurringDecimal.factionToDecimal(1, 22));
    }

    @Test
    void four() {
        System.out.println(FractionToRecurringDecimal.factionToDecimal(1, 97));
    }
}