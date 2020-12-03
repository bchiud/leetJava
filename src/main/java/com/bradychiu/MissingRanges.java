package com.bradychiu;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    /**
     * time: n
     * space: n
     */
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<String> result = new ArrayList<>();

        if (nums == null || n == 0) {
            addNewRange(result, lower, upper);
            return result;
        }

        if (lower < nums[0])
            addNewRange(result, lower, nums[0] - 1);

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > 1)
                addNewRange(result, nums[i - 1] + 1, nums[i] - 1);
        }

        if (nums[n - 1] < upper)
            addNewRange(result, nums[n - 1] + 1, upper);

        return result;
    }

    private static void addNewRange(List<String> result, int startVal, int endVal) {
        if (endVal - startVal == 0) {
            result.add(String.valueOf(startVal));
        } else {
            result.add(startVal + "->" + endVal);
        }
    }
}
