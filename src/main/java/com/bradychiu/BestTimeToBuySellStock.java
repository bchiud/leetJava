package com.bradychiu;

public class BestTimeToBuySellStock {

    /**
     * brute force
     * time: n ^ 2 / 2
     * space: 1
     */

    /**
     * find valley, and peak that follows
     * time: n
     * space: 1
     */
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int curPrice : prices) {
            buyPrice = Math.min(buyPrice, curPrice);
            maxProfit = Math.max(maxProfit, curPrice - buyPrice);
        }
        return maxProfit;
    }
}
