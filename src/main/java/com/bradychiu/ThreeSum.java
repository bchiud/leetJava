package com.bradychiu;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    // O(n^3) time //O(1) space
    public static List<List<Integer>> threeSumBrute(int[] nums) {
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

    // O(n^2) time and O(1) space
    public static List<List<Integer>> threeSumQuadratic(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if ( i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> combo = new ArrayList<>();
                    combo.add(nums[i]);
                    combo.add(nums[j]);
                    combo.add(nums[k]);
                    result.add(combo);
                    j++;
                    k--;
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

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        printResult(threeSumBrute(nums));
        printResult(threeSumQuadratic(nums));
    }
}
