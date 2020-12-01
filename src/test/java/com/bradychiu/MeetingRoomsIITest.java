package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsIITest {

    private static int runSolution(int[][] intervals) {
        // return MeetingRoomsII.minMeetingRoomsMinHeap(intervals);
        return MeetingRoomsII.minMeetingRoomsPointers(intervals);
    }

    @Test
    void one() {
        int[][] input = {{0, 30}, {5, 10}, {15, 20}};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void two() {
        int[][] input = {{7, 10}, {2, 4}};
        int expected = 1;

        assertEquals(expected, runSolution(input));
    }

    @Test
    void three() {
        int[][] input = {{1,5}, {8,9}, {8,9}};
        int expected = 2;

        assertEquals(expected, runSolution(input));
    }
}