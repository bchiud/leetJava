package com.bradychiu;

import java.util.Arrays;

public class TaskScheduler {

    // TODO: review

    /**
     * time: n log n
     * space: 1
     */

    public static int leastIntervalSort(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int idleTime = n * (maxFreq - 1);

        for (int i = freq.length - 2; i >= 0 && idleTime > 0; --i) {
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        idleTime = Math.max(0, idleTime);

        return idleTime + tasks.length;
    }

    /**
     * time: n
     * space: 1
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }

        // max frequency
        int f_max = 0;
        for (int f : frequencies) {
            f_max = Math.max(f_max, f);
        }

        // count the most frequent tasks
        int n_max = 0;
        for (int f : frequencies) {
            if (f == f_max) n_max++;
        }

        return Math.max(tasks.length, (f_max - 1) * (n + 1) + n_max);
    }
}
