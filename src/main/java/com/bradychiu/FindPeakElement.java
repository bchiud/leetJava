package com.bradychiu;

public class FindPeakElement {

    /**
     * time: n
     * space: 1
     */
    public static int findPeakElementSequential(int[] nums) {
        if (nums.length == 1)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                return i - 1;
        }

        return nums.length - 1;
    }

    /**
     * time: log(n)
     * space: 1
     */
    public static int findPeakElementBinarySearchRecursive(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int lo, int hi) {
        if (lo == hi)
            return lo;
        else if (lo + 1 == hi) {
            if (nums[lo] > nums[hi])
                return lo;
            else
                return hi;
        } else {
            int mid = (lo + hi) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1])
                return binarySearch(nums, lo, mid - 1);
            else
                return binarySearch(nums, mid + 1, hi);
        }
    }

    /**
     * time: log(n)
     * space: 1
     */
    public static int findPeakElementBinarySearchIterative(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
