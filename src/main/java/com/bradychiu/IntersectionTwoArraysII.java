package com.bradychiu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IntersectionTwoArraysII {
    /**
     * time: n1 + n2
     * space: n1
     */
    public static int[] intersectHashMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> storage = new HashMap<>();
        for (int n : nums1) {
            storage.put(n, storage.getOrDefault(n, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int n : nums2) {
            if (storage.containsKey(n)) {
                ans.add(n);
                int count = storage.get(n);
                if (count == 1) {
                    storage.remove(n);
                } else {
                    storage.put(n, count - 1);
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * time: n log n + m + log m expected, but n^2 + m^2 worst case
     * space: log n + log m
     */
    public static int[] intersectQuickSort(int[] nums1, int[] nums2) {
        quickSort(nums1);
        quickSort(nums2);
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i++];
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    private static void quickSort(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo)
            return;
        int partitionIndex = partition(nums, lo, hi);
        quickSort(nums, lo, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int partitionVal = lo;

        int i = lo;
        int j = hi + 1;

        while (true) {
            while (nums[++i] < partitionVal)
                if (i >= hi)
                    break;

            while (nums[--j] > partitionVal)
                if (j <= lo)
                    break;

            if (i >= j)
                break;

            swap(nums, i, j);
        }

        swap(nums, lo, j);

        return j;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private static void shuffle(int[] nums) {
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, r.nextInt(nums.length));
        }
    }

    /**
     * time: n log n + m log n
     * space: n + m
     */
    // public static int[] intersectMergeSort(int[] nums1, int[] nums2) {
    //
    // }

}
