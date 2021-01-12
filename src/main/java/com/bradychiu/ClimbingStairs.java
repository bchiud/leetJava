package com.bradychiu;

public class ClimbingStairs {
    /**
     * time: 2^n
     * space: n
     */
    public static int climbStairsRecursive(int n) {
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    /**
     * time: n
     * space: n
     */
    public static int climbingStairsMemoization(int n) {
        int memo[] = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return climbingStairsMemoizationHelper(memo, n);
    }

    private static int climbingStairsMemoizationHelper(int[] memo, int n) {
        if (memo[n] > 0)
            return memo[n];

        memo[n] = climbingStairsMemoizationHelper(memo, n - 1)
                + climbingStairsMemoizationHelper(memo, n - 2);
        return memo[n];
    }

    /**
     * time: n
     * space: n
     */
    public static int climbStairsDynamicProgramming(int n) {
        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * time: n
     * space: 1
     */
    public static int climbStairsDynamicProgrammingConstantSpace(int n) {
        if (n == 1)
            return 1;

        int one = 1;
        int two = 2;

        for(int i = 3; i <= n; i++) {
            int current = one + two;
            one = two;
            two = current;
        }

        return two;
    }


}
