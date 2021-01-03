package com.bradychiu;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {

    /**
     * time: n log min(n,k)
     * space: min(n,k)
     */
    public static boolean containsNearbyAlmostDuplicateBST(int[] nums, int k, int t) {
        // k distance, t difference
        TreeSet<Integer> storage = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = storage.ceiling(nums[i]);
            Integer floor = storage.floor(nums[i]);

            if ((ceiling != null && (long) ceiling <= t + (long) nums[i])
                    || (floor != null && (long) nums[i] <= (long) floor + (long) t))
                return true;

            storage.add(nums[i]);
            if (storage.size() > k)
                storage.remove(nums[i - k]);
        }

        return false;
    }

    /**
     * time: n
     * space: k
     */
    public static boolean containsNearbyAlmostDuplicateBuckets(int[] nums, int k, int t) {
        // k distance, t difference
        if (k < 1 || t < 0)
            return false;

        Map<Long, Long> buckets = new HashMap<>();
        long bucketWidth = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long curBucket = getBucket(nums[i], bucketWidth);

            if (buckets.containsKey(curBucket))
                return true;
            if (buckets.containsKey(curBucket - 1) && (long) nums[i] - buckets.get(curBucket - 1) <= (long) t)
                return true;
            if (buckets.containsKey(curBucket + 1) && buckets.get(curBucket + 1) - (long) nums[i] <= (long) t)
                return true;

            buckets.put(curBucket, (long) nums[i]);
            if (buckets.size() > k)
                buckets.remove(getBucket(nums[i - k], bucketWidth));
        }

        return false;
    }

    private static long getBucket(int n, long bucketWidth) {
        return ((long) n - Integer.MIN_VALUE) / bucketWidth;
    }
}
