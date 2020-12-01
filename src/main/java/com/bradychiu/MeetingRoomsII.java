package com.bradychiu;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

    /**
     * similar problems:
     * 56 Merge Intervals
     * 252 Meeting Rooms
     * 253 Meeting Rooms II
     * 435 Non-overlapping Intervals
     * 452 Minimum Number of Arrows to Burst Balloons
     */

    /**
     * time: n*log(n) ->
     * * sorting takes n*log(n)
     * * min heap
     * * * worst case has all meetings collide, so n add operations
     * * * min extraction takes n*log(n)
     *
     * space: n -> worst case heap is n
     */

    public static int minMeetingRoomsMinHeap(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals.length;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        Queue<Integer> roomEnds = new PriorityQueue<>((a,b) -> (a - b));
        for(int[] meeting : intervals) {
            // if room is free then free it up so current meeting can use
            if(!roomEnds.isEmpty() && meeting[0] >= roomEnds.peek())
                roomEnds.poll();


            roomEnds.add(meeting[1]);
        }

        return roomEnds.size();
    }

    /**
     * time: n*log(n) -> 2n*log(n) for 2 sorts, n for filling arrays and processing the rooms
     * space: n -> 2n for start and end arrays
     */
    public static int minMeetingRoomsPointers(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals.length;

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < intervals.length) {
            if(starts[startIndex] >= ends[endIndex]) {
                rooms--;
                endIndex++;
            }
            rooms++;
            startIndex++;
        }

        return rooms;
    }
}
