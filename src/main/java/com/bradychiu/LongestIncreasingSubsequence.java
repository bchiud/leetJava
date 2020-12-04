package com.bradychiu;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * time: n^2
     * space: n
     */
    public static int lengthOfLISDp(int[] nums) {
        if (nums == null)
            return 0;

        int n = nums.length;
        if (n <= 1)
            return n;

        int curLongest = 0;
        int[] lessThans = new int[nums.length];
        Arrays.fill(lessThans, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    lessThans[i] = Math.max(lessThans[j] + 1, lessThans[i]);
            }
            if (curLongest < lessThans[i])
                curLongest = lessThans[i];
        }

        return curLongest;
    }


    /**
     * time: n*log(n)
     * space: n
     * maintain a dp array "tails" of the smallest possible value for a subsequence of length i
     * binary search to find said value
     */
    public static int lengthOfLISDpBinarySearch(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int lo = 0, hi = size;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (x <= tails[mid])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            tails[lo] = x;
            if (lo == size)
                ++size;
        }
        return size;
    }

}
