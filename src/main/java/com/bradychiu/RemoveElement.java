package com.bradychiu;

public class RemoveElement {
    // this question was written poorly on leetcode

    static void printResult() {
        System.out.println("Remove Element");

        removeElement(new int[]{3,2,2,3}, 2);
    }

    static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int newPos = 0;

        for(int iter = 0; iter < len; iter++) {
            if(nums[iter] != val) {
                nums[newPos] = nums[iter];
                newPos++;
            }
        }

        return newPos;
    }
}
