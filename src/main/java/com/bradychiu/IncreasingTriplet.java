package com.bradychiu;

public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= small) small = n;
            else if (n <= mid) mid = n;
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = null;
        System.out.println(a == null);
    }
}
