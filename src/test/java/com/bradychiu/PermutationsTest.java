package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    private List<List<Integer>> runSolution(int[] input) {
        // return Permutations.permuteIterative(input);
        return Permutations.permuteRecursiveSwap(input);
    }

    @Test
    void one() {
        int[] input = new int[]{1, 2, 3};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        );

        List<List<Integer>> output = runSolution(input);

        assert(compareListOfLists(expected, output));
    }

    @Test
    void two() {
        int[] input = new int[]{0, 1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0)
        );

        assert(compareListOfLists(expected, runSolution(input)));
    }

    @Test
    void three() {
        int[] input = new int[]{1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );

        assert(compareListOfLists(expected, runSolution(input)));
    }

    private static boolean compareListOfLists(List<List<Integer>> a, List<List<Integer>> b) {
        return a.size() == b.size()
                && a.containsAll(b)
                && b.containsAll(a);
    }

}