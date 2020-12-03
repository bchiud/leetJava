package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void one() {
        int[] coins = new int[] {1,2,5};
        int amount = 11;
        int expected = 3;

        assertEquals(expected, CoinChange.coinChangeDP(coins, amount));
    }

    @Test
    void two() {
        int[] coins = new int[] {2};
        int amount = 3;
        int expected = -1;

        assertEquals(expected, CoinChange.coinChangeDP(coins, amount));
    }

    @Test
    void three() {
        int[] coins = new int[] {1};
        int amount = 0;
        int expected = 0;

        assertEquals(expected, CoinChange.coinChangeDP(coins, amount));
    }

    @Test
    void four() {
        int[] coins = new int[] {1};
        int amount = 1;
        int expected = 1;

        assertEquals(expected, CoinChange.coinChangeDP(coins, amount));
    }

    @Test
    void five() {
        int[] coins = new int[] {1};
        int amount = 2;
        int expected = 2;

        assertEquals(expected, CoinChange.coinChangeDP(coins, amount));
    }

}