package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindCelebrityTest {

    private static int runSolution(FindCelebrity fc, int people) {
        // return fc.findCelebrityBrute(people);
        // return fc.findCelebrityDeduce(people);
        return fc.findCelebrityDeduceFaster(people);
    }

    @Test
    void one() {
        int[][] socialGraph = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}
        };
        FindCelebrity fc = new FindCelebrity(socialGraph);

        assertEquals(1, runSolution(fc, socialGraph.length));
    }

    @Test
    void two() {
        int[][] socialGraph = new int[][]{
                {1, 1},
                {1, 1}
        };
        FindCelebrity fc = new FindCelebrity(socialGraph);

        assertEquals(-1, runSolution(fc, socialGraph.length));
    }

}