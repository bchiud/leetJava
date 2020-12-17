package com.bradychiu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MajorityElement {

    /**
     * time: n
     * space: n
     */
    public static int majorityElementHashMap(int[] nums) {
        int majorityOccur = 0;
        int majorityNum = 0;
        Map<Integer, Integer> storage = new HashMap<>();

        for (int n : nums) {
            int occur = storage.getOrDefault(n, 0) + 1;
            if (occur > majorityOccur) {
                majorityOccur = occur;
                majorityNum = n;
            }
            storage.put(n, occur);
        }

        return majorityNum;
    }

    /**
     * time: n*log(n)
     * space: 1
     */
    public static int majorityElementQuickSort(int[] nums) {
        quickSort(nums);
        return nums[nums.length / 2];
    }

    private static void quickSort(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if(hi <= lo) return;
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

            while (nums[--j] > partitionVal) {
                if (j <= lo)
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
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, r.nextInt(nums.length));
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    /**
     * time: n
     * space: 1
     */
    public static int majorityElementBoyerMooreVotingAlgo(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int n : nums) {
            if(count == 0)
                candidate = n;
            count += (n == candidate ? 1 : -1);
        }

        return candidate;
    }

}
