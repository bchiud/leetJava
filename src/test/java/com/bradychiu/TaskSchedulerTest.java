package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    private static int runSolution(char[] tasks, int n) {
        // return TaskScheduler.leastIntervalSort(tasks, n);
        return TaskScheduler.leastInterval(tasks, n);
    }

    @Test
    void one() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        assertEquals(8, runSolution(tasks, n));
    }

    @Test
    void two() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;

        assertEquals(6, runSolution(tasks, n));
    }

    @Test
    void three() {
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;

        assertEquals(16, runSolution(tasks, n));
    }
}