package com.bradychiu;

import java.util.*;

public class TwoSum {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    static int[] twoSumBrute(int[] nums, int target) {
        int len = nums.length;

        for (int numOne = 0; numOne < len; numOne++) {
            for (int numTwo = numOne + 1; numTwo < len; numTwo++) {
                if (nums[numOne] + nums[numTwo] == target) {
                    return new int[]{numOne, numTwo};
                }
            }
        }

        return new int[]{0, 0};
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    static int[] twoSumHashing(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{0, 0};
    }

    /**
     * Time: O(n log n) for quick sort, O(n log n) for binary search
     * Space: O(log n) for quick sort
     */
    static int[] twoSumSortedBinarySearch(int[] numbers, int target) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int pairIndex = Arrays.binarySearch(numbers, target - numbers[i]);
            if (pairIndex >= 0) {
                if (pairIndex != i ||
                        (i > 0 && numbers[i] == numbers[ i - 1]) ||
                        (i < numbers.length - 1 && numbers[i] == numbers[i + 1])) {
                    return new int[] {i, pairIndex};
                }
            }
        }
        return new int[]{0, 0};
    }

    /**
     * Time: O(n log n) for quick sort
     * Space: O(log n) for quick sort
     */
    static int[] twoSumSortedPointers(int[] numbers, int target) {
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {

    }
}
