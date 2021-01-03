package com.bradychiu;

import java.util.HashSet;
import java.util.Set;

class SingleNumber {

    /**
     * time: n
     * space: n
     */

    public static int singleNumberSet(int[] nums) {
        Set<Integer> storage = new HashSet<>();
        for (int n : nums) {
            if (storage.contains(n)) {
                storage.remove(n);
            } else {
                storage.add(n);
            }
        }

        return (int) storage.toArray()[0];
    }

    /**
     * time: n
     * space: n
     */
    public static int singleNumberMath(int[] nums) {
        Set<Integer> storage = new HashSet<>();
        int sum = 0;
        for (int n : nums) {
            if(!storage.contains(n))
                storage.add(n);
            sum += n;
        }

        return 2 * storage.stream().mapToInt(x -> x).sum() - sum;
    }

    /**
     * TODO: review bitwise operator
     *
     * XOR
     * time: n
     * space: 1
     */
    public static int singleNumberBitManipulation(int[] nums) {
        int a = 0;
        for (int n : nums) {
            a ^= n;
        }
        return a;
    }
}