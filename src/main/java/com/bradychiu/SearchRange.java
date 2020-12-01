package com.bradychiu;

public class SearchRange {

    /**
     * time: log(n)
     * space: 1
     */

    public static int[] searchRangeBinaryRecursive(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int lo = firstGreaterEqualBinaryRecursive(nums, target, 0, nums.length);
        if (lo == nums.length || nums[lo] != target)
            return new int[]{-1, -1};
        int nextTargetLo = firstGreaterEqualBinaryRecursive(nums, target + 1, lo + 1, nums.length);
        return new int[]{lo, nextTargetLo - 1};
    }

    private static int firstGreaterEqualBinaryRecursive(int[] nums, int target, int lo, int hi) {
        if (lo >= hi)
            return lo;

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < target)
            return firstGreaterEqualBinaryRecursive(nums, target, mid + 1, hi);
        else
            return firstGreaterEqualBinaryRecursive(nums, target, lo, mid);
    }

    /**
     * time: log(n)
     * space: 1
     */

    public static int[] searchRangeBinaryIterative(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int lo = firstGreaterEqualBinaryIterative(nums, target);
        if (lo == nums.length || nums[lo] != target)
            return new int[]{-1, -1};
        int nextTargetLo = firstGreaterEqualBinaryIterative(nums, target + 1);
        return new int[]{lo, nextTargetLo - 1};
    }

    private static int firstGreaterEqualBinaryIterative(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}
