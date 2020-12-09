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
     *
     * https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * 1. If "nums" is smallest among all end
     *    candidates of active lists, we will start
     *    new active list of length 1.
     * 2. If "nums" is largest among all end candidates of
     *    active lists, we will clone the largest active
     *    list, and extend it by "nums".
     * 3. If "nums" is in between, we will find a list with
     *    largest end element that is smaller than "nums".
     *    Clone and extend this list by "nums". We will discard all
     *    other lists of same length as that of this modified list.
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
