package com.bradychiu;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo, hi);
            lo++;
            hi --;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}
