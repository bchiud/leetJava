package com.bradychiu;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberIII {
    /**
     * time: n
     * space: n
     */
    public static int[] singleNumbersSet(int[] nums) {
        Set<Integer> storage = new HashSet<>();
        for (int n : nums) {
            if (!storage.contains(n)) {
                storage.add(n);
            } else {
                storage.remove(n);
            }
        }

        return storage.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution
     * XOR numbers
     * find lowbit which differs
     * create XOR all numbers which match lowbit
     * <p>
     * time: n
     * space: 1
     */
    public static int[] singleNumberBitmaks(int[] nums) {
        int bitmask = 0;
        for (int n : nums)
            bitmask ^= n;

        /**
         *    2 : 0010
         *   -2 : 1110 = 1101 -> 1110
         * diff : 0010
         */
        int diff = bitmask & -bitmask;

        int x = 0;
        for (int n : nums)
            if ((n & diff) != 0)
                x ^= n;

        return new int[] {x, bitmask ^ x};
    }
}
