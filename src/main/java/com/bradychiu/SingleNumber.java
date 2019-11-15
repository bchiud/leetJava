package com.bradychiu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;

class SingleNumber {
    public static void printResults() {
        System.out.println("Single Number ");

        System.out.println(new StringBuilder()
                .append("Original: ")
                .append(SingleNumber.singleNumberOriginal(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}))
                .toString());
        System.out.println(new StringBuilder()
                .append("Math: ")
                .append(SingleNumber.singleNumberMath(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}))
                .toString());
        System.out.println(new StringBuilder()
                .append("HashSet: ")
                .append(SingleNumber.singleNumberHashSet(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}))
                .toString());
        System.out.println(new StringBuilder()
                .append("Pairs: ")
                .append(SingleNumber.singleNumberPairs(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}))
                .toString());
        System.out.println(new StringBuilder()
                .append("Optimal: ")
                .append(SingleNumber.singleNumberOptimal(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8}))
                .toString());
    }

    static int singleNumberOriginal(int[] nums) { // 223ms
        int[] uniques = IntStream.of(nums).distinct().toArray();

        int uniquesLen = uniques.length;
        int numsLen = nums.length;
        int count = 0;

        for (int i : uniques) {
            for (int j : nums) {
                if (i == j) count++;
            }
            if (count == 1) return i;
            count = 0;
        }

        return 0;
    }

    static int singleNumberMath(int[] nums) { // 96 ms
        int[] uniques = IntStream.of(nums).distinct().toArray();

        return 2 * IntStream.of(uniques).sum() - IntStream.of(nums).sum();
    }

    static int singleNumberHashSet(int[] nums) { // 16ms
        HashSet<Integer> a = new HashSet<>();
        int y;
        for (int i : nums) {
            // System.out.println(a);
            if (!a.contains(i)) a.add(i);                //add all the elements into the hashset
            else a.remove(i);                           //remove the elements that occur more than once
        }
        Iterator iter = a.iterator();                   //the remaining element in the hashset is the one we want
        y = (int) iter.next();
        return y;
    }

    static int singleNumberPairs(int[] nums) { // 6 ms
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[nums.length - 1];
    }

    static int singleNumberOptimal(int[] nums) { // 1ms
        int ans = 0;

        for (int i : nums) {
            ans ^= i;
            // System.out.println(i + ", " + ans);
        }

        return ans;

    }
}
