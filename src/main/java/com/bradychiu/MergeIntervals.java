package com.bradychiu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /**
     * similar problems:
     * 56 Merge Intervals
     * 252 Meeting Rooms
     * 253 Meeting Rooms II
     * 435 Non-overlapping Intervals
     * 452 Minimum Number of Arrows to Burst Balloons
     */

    /**
     * time: n log(n) + n -> n log(n)
     * space: n (worst case if no overlaps)
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] curInterval : intervals) {
            if (curInterval[0] <= newInterval[1])
                newInterval[1] = Math.max(curInterval[1], newInterval[1]);
            else {
                newInterval = curInterval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
