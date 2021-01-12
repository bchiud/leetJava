package com.bradychiu;

public class HouseRobber {
    /**
     * time: n
     * space: n
     */
    public int robLinearSpace(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return Math.max(0, nums[0]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public int robConstantSpace(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int prevMax = 0;
        int currMax = 0;
        for (int value : nums) {
            int tmpCurrMax = currMax;
            currMax = Math.max(value + prevMax, currMax);
            prevMax = tmpCurrMax;
        }

        return currMax;
    }

}
