package com.bradychiu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    /**
     * time: n
     * space: k
     */

    public boolean containsNearbyDuplicateHashSet(int[] nums, int k) {

        Set<Integer> storage = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (storage.contains(nums[i])) {
                return true;
            } else {
                storage.add(nums[i]);
            }
            if (storage.size() > k)
                storage.remove(nums[i - k]);
        }

        return false;
    }

    /**
     * time: n
     * space: n
     */

    public boolean containsNearbyDuplicateHashMap(int[] nums, int k) {
        // value, position
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (storage.containsKey(nums[i]) && i - storage.get(nums[i]) <= k)
                return true;
            else
                storage.put(nums[i], i);
        }

        return false;
    }
}
