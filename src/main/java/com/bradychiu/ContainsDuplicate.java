package com.bradychiu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * time: n log n
     * space: 1
     */
    public static boolean containsDuplicateSort(int[] nums) {
        if (nums.length <= 1)
            return false;

        // Arrays.sort(nums);
        quickSort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int partitionIndex = partition(nums, lo, hi);
        quickSort(nums, lo, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int partitionVal = nums[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (nums[++i] < partitionVal) {
                if (i >= hi)
                    break;
            }

            while (partitionVal < nums[--j]) {
                if (lo >= j)
                    break;
            }

            if (i >= j)
                break;

            swap(nums, i, j);
        }

        swap(nums, lo, j);

        return j;
    }

    private static void shuffle(int[] nums) {
        Random r = new Random();
        for (int i = 0; i < nums.length; i++)
            swap(nums, i, r.nextInt(nums.length));
    }

    private static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }


    /**
     * time: n
     * space: n
     */
    public static boolean containsDuplicateLinear(int[] nums) {
        Set<Integer> storage = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (storage.contains(nums[i])) {
                return true;
            } else {
                storage.add(nums[i]);
            }
        }
        return false;
    }
}
