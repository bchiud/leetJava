package com.bradychiu;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * time: n * 2^n
     * space: n * 2^n
     * <p>
     * 2^n: There are 2^n possible subsets. For each element, you have two choices:
     * either you put it in your subset, or you don't; and these choices are all independent.
     * <p>
     * n: We iterate from [1:n] subsets.
     */
    public static List<List<Integer>> subsetsCascading(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0)
            return result;

        for (int curNum : nums) {
            int size = result.size();

            for (int i = 0; i < size; i++) {
                result.add(new ArrayList<>(result.get(i)));

                result.get(size + i).add(curNum);
            }
        }

        return result;
    }


    /**
     * TODO: low pri
     * time:
     * space:
     *
     * ??
     */

    private static List<List<Integer>> output = new ArrayList();
    private static int n, k;

    public static List<List<Integer>> subsetsBacktracking(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {

        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            System.out.print("Added: ");
            printList(curr);
            System.out.println();
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);

            System.out.print("k: " + k + "; ");
            System.out.print("first: " + first + "; ");
            System.out.print("i: " + i + "; ");
            printList(curr);
            System.out.println();

            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    private static void printList(List<Integer> list) {
        if (list == null || list.size() == 0)
            return;

        for (int i = 0; i < list.size() - 1; i++)
            System.out.print(i + ", ");
        System.out.print(list.get(list.size() - 1));
    }

    /**
     * time: n * 2^n
     * space: n * 2^n
     */

    public static List<List<Integer>> subsetsBitmask(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j < bitmask.length(); j++)
                if (bitmask.charAt(j) == '1')
                    curList.add(nums[j]);
            System.out.print("Integer: " + i + "; Bitmask: " + bitmask + "; List: ");
            printList(curList);
            System.out.println();
            result.add(curList);
        }

        return result;
    }
}
