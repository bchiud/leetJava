package com.bradychiu;

import java.util.Arrays;

public class MinArrowsToBurstBalloons {

    /**
     * similar problems:
     * 56 Merge Intervals
     * 252 Meeting Rooms
     * 253 Meeting Rooms II
     * 435 Non-overlapping Intervals
     * 452 Minimum Number of Arrows to Burst Balloons
     */

    /**
     * time: n*log(n)
     * space: log(n) -> Arrays.sort uses QuickSort for primitives -> QuickSort makes log(n) recursive calls where each call uses constant space
     */

    public static int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int startIndex = points[0][0];
        int endIndex = points[0][1];
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {
            // no overlap
            if (points[i][0] > endIndex) {
                arrows++;
                startIndex = points[i][0];
                endIndex = points[i][1];
            }

            // overlap
            if (points[i][0] > startIndex)
                startIndex = points[i][0];
            if (points[i][1] < endIndex)
                endIndex = points[i][1];
        }

        return arrows;
    }

}
