package com.bradychiu;

import java.util.*;

class TwoSum {
    public static void printResults() {
        System.out.println(new StringBuilder()
                .append("Two Sum Original: ")
                .append(Arrays.toString(TwoSum.twoSumOriginal(new int[]{2, 7, 11, 15}, 9)))
                .toString());
        System.out.println(new StringBuilder()
                .append("Two Sum Optimal: ")
                .append(Arrays.toString(TwoSum.twoSumOptimal(new int[]{2, 7, 11, 15}, 9)))
                .toString());
    }

    static int[] twoSumOriginal(int[] nums, int target) {
        int len = nums.length;

        for(int numOne = 0; numOne < len; numOne++) {
            for(int numTwo = numOne + 1; numTwo < len; numTwo++) {
                if(nums[numOne] + nums[numTwo] == target) {
                    return new int[] {numOne, numTwo};
                }
            }
        }

        return new int[] {0,0};
    }

    static int[] twoSumOptimal(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i};
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
