package com.bradychiu;

import java.util.Arrays;

public class RemoveDupsFromSortedArray {

    /**
     * time: n
     * space: 1
     */

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int lastUniqueIndex = 0;
        int currentIndex = 1;
        while (currentIndex < nums.length) {
            if (nums[currentIndex] != nums[lastUniqueIndex]) {
                lastUniqueIndex++;
                nums[lastUniqueIndex] = nums[currentIndex];
            }
            currentIndex++;
        }

        return lastUniqueIndex + 1;
    }
}
