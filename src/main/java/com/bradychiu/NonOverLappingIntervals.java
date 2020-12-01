package com.bradychiu;

import java.util.Arrays;

public class NonOverLappingIntervals {

    /**
     * similar problems:
     * 56 Merge Intervals
     * 252 Meeting Rooms
     * 253 Meeting Rooms II
     * 435 Non-overlapping Intervals
     * 452 Minimum Number of Arrows to Burst Balloons
     */

    /**
     * time: n*log(n) -> n*log(n) for sort, n for processing the intervals
     * space: log(n) -> Arrays.sort uses QuickSort for primitives -> QuickSort makes log(n) recursive calls where each call uses constant space
     * algo: take the earliest finishing intervals; https://www.youtube.com/watch?v=2LUQ6tBdGxo
     */
    public static int eraseOverlapIntervalsMinHeap(int[][] intervals) {
        if (intervals.length <= 1)
            return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int lastEnd = intervals[0][1];
        int keep = 1;

        for (int[] in : intervals) {
            // is not overlapping
            if (lastEnd <= in[0]) {
                lastEnd = in[1];
                keep++;
            }
        }

        return intervals.length - keep;
    }


}
