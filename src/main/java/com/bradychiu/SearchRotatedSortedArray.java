package com.bradychiu;

public class SearchRotatedSortedArray {

    /**
     * time: log(n)
     * space: log(n) -> log(n) recursive calls with constant space each call
     */

    public static int searchBinaryRecursive(int[] nums, int target) {
        int n = nums.length;

        if (nums == null || n == 0)
            return -1;

        if (n == 1)
            return nums[0] == target ? 0 : -1;

        return searchBinaryRecursiveHelper(nums, target, 0, n - 1);
    }

    private static int searchBinaryRecursiveHelper(int[] nums, int target, int lo, int hi) {
        if (target < nums[lo] && nums[hi] < target)
            return -1;
        if (lo >= hi)
            return nums[lo] == target ? lo : -1;

        int mid = lo + (hi - lo) / 2;
        int left = -1, right = -1;
        if (nums[mid] < target || target <= nums[hi])
            left = searchBinaryRecursiveHelper(nums, target, mid + 1, hi);
        if (nums[lo] <= target || target <= nums[mid])
            right = searchBinaryRecursiveHelper(nums, target, lo, mid);

        return Integer.max(left, right);
    }

    /**
     * time: log(n)
     * space: 1
     */

    public static int searchBinaryIterative(int[] nums, int target) {
        int n = nums.length;

        if (nums == null || n == 0)
            return -1;

        if (n == 1)
            return nums[0] == target ? 0 : -1;

        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            if (target < nums[lo] && nums[hi] < target)
                return -1;

            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[lo] <= nums[mid]) { // bottom half is in order
                if (nums[lo] <= target && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else { // top half is in order
                if (nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }

}
