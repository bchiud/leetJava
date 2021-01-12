package com.bradychiu;

public class BestTimeToBuySellStockIII {
    // TODO:

    /**
     * time: n
     * space: 1
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int costOne = Integer.MAX_VALUE;
        int profitOne = 0;
        int costTwo = Integer.MAX_VALUE;
        int profitTwo = 0;

        for (int price : prices) {
            costOne = Math.min(costOne, price);
            profitOne = Math.max(profitOne, price - costOne);
            costTwo = Math.min(costTwo, price - profitOne);
            profitTwo = Math.max(profitTwo, price - costTwo);
        }

        return profitTwo;
    }
}
