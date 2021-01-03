package com.bradychiu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumberII {
    /**
     * time: n
     * space: n
     */
    public static int singleNumberSet(int[] nums) {
        Set<Integer> storage = new HashSet<>();
        int sum = 0;
        for (int n : nums) {
            if (!storage.contains(n))
                storage.add(n);
            sum += n;
        }

        return (3 * storage.stream().mapToInt(x -> x).sum() - sum) / 2;
    }

    /**
     * time: n
     * space: n / 3 + 1
     */
    public static int singleNumberHashMap(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (int k : count.keySet()) {
            if (count.get(k) == 1)
                return k;
        }

        return -1;
    }

    /**
     * seenOnce = NOT seenTwice AND XOR seenOnce
     * seenTwice = NOT seenOnce AND XOR seenTwice
     *
     * 1st pass:
     * - seenOnce = true = not in seenTwice, XOR into seenOnce
     * - seenTwice = false = in seenOnce
     *
     * 2nd pass:
     * - seenOnce = false = not in seenTwice, XOR out of seenOnce
     * - seenTwice = true = not in seenOnce, XOR into seenTwice
     *
     * 3rd pass:
     * - seenOnce = false = in seenTwice
     * - seenTwice = false = not in seenOnce, XOR out of seenTwice
     * time: n
     * time : 1
     */
    public static int singleNumberBitwise(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;

        for (int n : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ n);
            seenTwice = ~seenOnce & (seenTwice ^ n);
        }

        return seenOnce;
    }

}
