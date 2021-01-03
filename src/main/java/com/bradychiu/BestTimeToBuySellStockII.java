package com.bradychiu;

public class BestTimeToBuySellStockII {
    /**
     * brute force:
     * time: n^n
     * space: n
     */


    /**
     * time: n
     * space: 1
     */
    public static int maxProfitPointers(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int curIndex = 0;
        int valley = 0;
        int peak = 0;
        int profit = 0;

        while (curIndex < prices.length - 1) {
            while (curIndex < prices.length - 1 && prices[curIndex] >= prices[curIndex] + 1) {
                curIndex++;
            }
            valley = prices[curIndex];

            while (curIndex < prices.length - 1 && prices[curIndex] <= prices[curIndex] + 1) {
                curIndex++;
            }
            peak = prices[curIndex];

            profit += peak - valley;
        }

        return profit;
    }

    /**
     * time: n
     * space: 1
     */

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i])
                profit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}
