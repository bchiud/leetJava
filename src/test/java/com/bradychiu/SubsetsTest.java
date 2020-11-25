package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    private List<List<Integer>> runSolution(int[] input) {
        // return Subsets.subsetsCascading(input);
        // return Subsets.subsetsBacktracking(input);
        System.out.println(Subsets.subsetsBitmask(input));
        return Subsets.subsetsBitmask(input);
    }

    @Test
    void one() {
        int[] input = new int[]{0};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(0));

        assert (equalsListofLists(expected, runSolution(input)));
    }

    @Test
    void two() {
        int[] input = new int[]{1, 2};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1, 2));

        assert (equalsListofLists(expected, runSolution(input)));
    }

    @Test
    void three() {
        int[] input = new int[]{1, 2, 3};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(1, 2, 3));

        assert (equalsListofLists(expected, runSolution(input)));
    }

    private boolean equalsListofLists(List<List<Integer>> a, List<List<Integer>> b) {
        return a.size() == b.size()
                && a.containsAll(b)
                && b.containsAll(a);
    }

    private void printListOfLists(List<List<Integer>> input) {
        String output = "[";
        for (List<Integer> l : input) {
            String lString = "[";

            if (l.size() > 0) {
                for (Integer n : l) {
                    lString += n + ", ";
                }

                lString = lString.substring(0, lString.length() - 2);
            }

            lString += "]";

            output += lString + ", ";
        }

        output = output.substring(0, output.length() - 2);
        output += "]";

        System.out.println(output);
    }
}