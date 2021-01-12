package com.bradychiu;

import com.bradychiu.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeLevelOrderTraversalTest {

    private static List<List<Integer>> runSolution(TreeNode root) {
        return BinaryTreeLevelOrderTraversal.levelOrderBfsIterative(root);
        // return BinaryTreeLevelOrderTraversal.levelOrderDfsRecursion(root);
    }

    @Test
    void one() {

        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(9, 20));
        expected.add(Arrays.asList(15, 7));

        assertTrue(listOfListEquals(expected, runSolution(root)));
    }

    @Test
    void two() {

        TreeNode rll = new TreeNode(21);
        TreeNode rlr = new TreeNode(22);
        TreeNode rl = new TreeNode(15, rll, rlr);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(9, 20));
        expected.add(Arrays.asList(15, 7));
        expected.add(Arrays.asList(21, 22));

        assertTrue(listOfListEquals(expected, runSolution(root)));
    }

    private static boolean listOfListEquals(List<List<Integer>> l1, List<List<Integer>> l2) {
        return l1.size() == l2.size()
                && l1.containsAll(l2)
                && l2.containsAll(l1);
    }

}