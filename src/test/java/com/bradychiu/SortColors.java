package com.bradychiu;

import java.util.Arrays;

public class SortColors {

    /**
     * time: 2n
     * space: 1
     */
    public static void sortColorsTwoPass(int[] nums) {
        int zero = 0, one = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
            if (nums[i] == 1)
                one++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
            }
        }
    }

    /**
     * time: n
     * space: 1
     */
    public static void sortColorsOnePass(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
            } else {
                swap(nums, mid, high);
                high--;
                mid--;
            }
            mid++;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        // System.out.println("Swapping: " + a + " & " + b);
        // System.out.println("Pre: " + arrayToString(nums));

        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;

        // System.out.println("Post: " + arrayToString(nums));
    }

    private static String arrayToString(int[] nums) {
        String s = "";
        s += String.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++)
            s += ", " + String.valueOf(nums[i]);
        return s;
    }
}
