package com.bradychiu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindCelebrity {
    private int[][] socialGraph;

    public FindCelebrity(int[][] socialGraph) {
        this.socialGraph = socialGraph;
    }

    /**
     * time: n^2
     * space: 1
     */

    public int findCelebrityBrute(int n) {
        if (n < 2)
            return -1;

        int[] knownBy = new int[n];

        for (int i = 0; i < n; i++) {
            boolean isCeleb = true;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (knows(i, j) || !knows(j, i)) {
                    isCeleb = false;
                    break;
                }
            }

            if (isCeleb)
                return i;
        }

        return -1;
    }

    /**
     * time: n
     * space: 1
     */
    public int findCelebrityDeduce(int n) {
        if (n < 2)
            return -1;

        int celebCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebCandidate, i)) {
                celebCandidate = i;
            }
        }

        int knownBy = 0;
        for (int i = 0; i < n; i++) {
            if (i == celebCandidate) {
                knownBy++;
                continue;
            }
            if (knows(i, celebCandidate) && !knows(celebCandidate, i))
                knownBy++;
        }

        return knownBy == n ? celebCandidate : -1;
    }

    /**
     * time: n
     * space: 1
     */
    public int findCelebrityDeduceFaster(int n) {
        int celebCandidate = 0;
        for (int i = 0; i < n; ++i) if (knows(celebCandidate, i)) celebCandidate = i;
        for (int i = 0; i < celebCandidate; ++i) if (knows(celebCandidate, i)) return -1;
        for (int i = 0; i < n; ++i) if (!knows(i, celebCandidate)) return -1;
        return celebCandidate;
    }

    public boolean knows(int a, int b) {
        return socialGraph[a][b] == 1;
    }
}
