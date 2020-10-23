package com.bradychiu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    // time: O(n^2)
    // space: O(1)
    public static List<List<Integer>> threeSumQuadratic(int[] nums) {
        List<List<Integer>> combos = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > 0)
                break;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    combos.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return combos;
    }


    // time: O(n^3)
    // space: O(1)
    public static List<List<Integer>> threeSumCubic(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> combo = new ArrayList<>();
                        combo.add(nums[i]);
                        combo.add(nums[j]);
                        combo.add(nums[k]);
                        result.add(combo);
                    }
                }
            }
        }

        return result;
    }

    public static void printResult(List<List<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            List<Integer> current = result.get(i);
            System.out.println(i + ": (" + current.get(0) + ", " + current.get(1) + ", " + current.get(2) + ")");
        }
    }
}
