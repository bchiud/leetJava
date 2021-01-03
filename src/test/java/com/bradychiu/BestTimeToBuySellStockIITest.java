package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuySellStockIITest {

    private static int runSolution(int[] prices) {
        return BestTimeToBuySellStockII.maxProfitPointers(prices);
        // return BestTimeToBuySellStockII.maxProfit(prices);
    }

    @Test
    void one() {
        int[] prices = new int[] {7,1,5,3,6,4};
        int maxProfit = 7;

        assertEquals(maxProfit, runSolution(prices));
    }

    @Test
    void two() {
        int[] prices = new int[] {1,2,3,4,5};
        int maxProfit = 4;

        assertEquals(maxProfit, runSolution(prices));
    }

    @Test
    void three() {
        int[] prices = new int[] {7,6,4,3,1};
        int maxProfit = 0;

        assertEquals(maxProfit, runSolution(prices));
    }
}