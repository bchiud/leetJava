package com.bradychiu;

public class RemoveElement {
    // this question was written poorly on leetcode

    public static void main(String args[]) {
        printResult();
    }

    static void printResult() {
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
