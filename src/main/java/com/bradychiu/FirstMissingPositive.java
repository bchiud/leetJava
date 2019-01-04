package com.bradychiu;

import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String args[]) {
        System.out.println(firstMissingPositiveOriginal(new int[]{1,2,0}));
        System.out.println(firstMissingPositiveOriginal(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositiveOriginal(new int[]{7,8,9,11,12}));

        System.out.println(firstMissingPositiveBetter(new int[]{1,2,0}));
        System.out.println(firstMissingPositiveBetter(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositiveBetter(new int[]{7,8,9,11,12}));
    }

    static int firstMissingPositiveOriginal(int[] nums) {
        // this is not constant space b/c hashset grows

        int len = nums.length;
        HashSet<Integer> uniquePositives = new HashSet<>();

        for(int i = 0; i < len; i++) {
            if(nums[i] > 0 && !uniquePositives.contains(nums[i])) {
                uniquePositives.add(nums[i]);
            }
        }

        int curInt = 1;
        while(true) {
            if(!uniquePositives.contains(curInt)) break;
            curInt++;
        }

        return curInt;
    }

    static int firstMissingPositiveBetter(int[] nums) {
        // https://leetcode.com/problems/first-missing-positive/discuss/17135/Java-solution-with-integers-encode-trick-explained

        int n = nums.length;

        // overwrite negatives and >n elements as 0
        for(int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 0;
        }

        // move value to its index
        int m = n + 1;
        for (int i = 0; i < n; i++) {
            // retrieve the value that initially was at index i (it could be overwritten by encoding)
            int prev = nums[i] % m;
            if (prev > 0)
                // encode it using formula k * n + m, where for 'm' we also use decoding schema
                nums[prev - 1] = (prev * m) + nums[prev - 1] % m;
        }

        // find missing #
        for (int i = 0; i < n; i++) {
            if (nums[i] / m != i + 1) return i + 1;
        }

        return m;

    }
}
