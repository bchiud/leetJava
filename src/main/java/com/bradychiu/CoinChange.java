package com.bradychiu;

import java.util.Arrays;

public class CoinChange {

    /**
     * time: coins * amount
     * space: amount
     */
    public static int coinChangeDP(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];                         // min # of coins to make a given amount
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for(int i = 0; i <= amount; i++) {                      // for each amount
            for (int j = 0; j < coins.length; j++) {            // for each coin
                if (coins[j] <= i) {                            // if coin value < amount
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
