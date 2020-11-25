package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeZigzagLevelOrderTraversalTest {

    private List<List<Integer>> runSolution(TreeNode root) {
        // return BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrderRecursive(root);
        return BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrderTwoStackAlternating(root);
        // return BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrderTwoStack(root);
    }

    @Test
    void one() {
        TreeNode rr = new TreeNode(7);
        TreeNode rl = new TreeNode(15);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode l = new TreeNode(9);
        TreeNode root = new TreeNode(3, l, r);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(20, 9));
        expected.add(Arrays.asList(15, 7));

        equalsListOfLists(expected, runSolution(root));
    }

    @Test
    void two() {
        TreeNode rr = new TreeNode(5);
        TreeNode ll = new TreeNode(4);
        TreeNode r = new TreeNode(3, null, rr);
        TreeNode l = new TreeNode(2, ll, null);
        TreeNode root = new TreeNode(1, l, r);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(3, 2));
        expected.add(Arrays.asList(4, 5));

        List<List<Integer>> actual = runSolution(root);

        equalsListOfLists(expected, actual);
    }

    private void equalsListOfLists(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}