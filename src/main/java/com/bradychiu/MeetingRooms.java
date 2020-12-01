package com.bradychiu;

import java.util.Arrays;

public class MeetingRooms {

    /**
     * similar problems:
     * 56 Merge Intervals
     * 252 Meeting Rooms
     * 253 Meeting Rooms II
     * 435 Non-overlapping Intervals
     * 452 Minimum Number of Arrows to Burst Balloons
     */

    /**
     * time: n
     * space: space: log(n) -> Arrays.sort uses QuickSort for primitives -> QuickSort makes log(n) recursive calls where each call uses constant space
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1)
            return true;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0])
                return false;
        }

        return true;
    }
}
