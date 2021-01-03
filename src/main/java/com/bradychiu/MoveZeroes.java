package com.bradychiu;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int curIndex = 0;
        int nextNumIndex = 0;
        while (curIndex < nums.length) {
            if (nextNumIndex >= nums.length) {
                nums[curIndex++] = 0;
            } else if (nums[nextNumIndex] == 0) {
                nextNumIndex++;
            } else {
                nums[curIndex++] = nums[nextNumIndex++];
            }
        }
    }
}
