package com.bradychiu;

import com.sun.media.jfxmedia.logging.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {


    /**
     * time:    n! * n^2    ->  n!
     * space:   n! * n      ->  n!
     */

    public static List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        result.add(new ArrayList<Integer>());                   //  time    space
        for (int curNum : nums) {                               //  n
            List<List<Integer>> curRes = new ArrayList<>();     //          n!
            for (List<Integer> curPer : result) {               //  n!
                for (int k = 0; k <= curPer.size(); k++) {      //  n
                    curPer.add(k, curNum);                      //
                    List<Integer> tmp = new ArrayList(curPer);  //          n
                    curRes.add(tmp);
                    curPer.remove(k);
                }
            }
            result = curRes;
        }

        return result;
    }

    /**
     * TODO
     * time:
     * space:
     *
     * permute(nums, 0, 3, result)
     */

    public static List<List<Integer>> permuteRecursiveSwap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        permute(nums, 0, result);

        return result;
    }

    private static void permute(int[] nums, int start, List<List<Integer>> result) {

        if (start == nums.length)
            result.add(arrToList(nums));

        for (int i = start; i < nums.length; i++) {

            swap(nums, start, i);
            permute(nums, start + 1, result);
            swap(nums, start, i);
        }

    }

    private static void swap(int[] arr, int a, int b) {

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static List<Integer> arrToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer n : nums)
            list.add(n);
        return list;
    }

}
