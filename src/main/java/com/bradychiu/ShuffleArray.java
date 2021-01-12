package com.bradychiu;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    private int[] original;

    public ShuffleArray(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(original, original.length);
        Random r = new Random();
        for (int i = 0; i < original.length; i++) {
            int j = r.nextInt(shuffled.length);

            int tmp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = tmp;
        }

        return shuffled;
    }
}
