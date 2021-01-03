package com.bradychiu;

import java.util.*;

public class TwoSum {
    /**
     * Time: n^2
     * Space: 1
     */
    public static int[] twoSumBrute(int[] nums, int target) {
        int len = nums.length;

        for (int numOne = 0; numOne < len; numOne++) {
            for (int numTwo = numOne + 1; numTwo < len; numTwo++) {
                if (nums[numOne] + nums[numTwo] == target) {
                    return new int[]{numOne, numTwo};
                }
            }
        }

        return new int[]{0, 0};
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public static int[] twoSumHashing(int[] nums, int target) {
        Map<Integer, Integer> valIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valIndex.containsKey(target - nums[i]))
                return new int[]{valIndex.get(target - nums[i]), i};
            valIndex.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
