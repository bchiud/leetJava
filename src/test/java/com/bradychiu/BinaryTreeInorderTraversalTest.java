package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeInorderTraversalTest {

    private List<Integer> runSolution(TreeNode root) {
        return BinaryTreeInorderTraversal.inOrderTraversalIterative(root);
        // return BinaryTreeInorderTraversal.inorderTraversalRecursive(root);
    }

    @Test
    void one() {
        TreeNode rl = new TreeNode(3);
        TreeNode r = new TreeNode(2, rl, null);
        TreeNode root = new TreeNode(1, null, r);

        List<Integer> expected = Arrays.asList(1,3,2);

        assertEquals(expected, runSolution(root));
    }

    @Test
    void two() {
        List<Integer> expected = new ArrayList<>();

        assertEquals(expected, runSolution(null));
    }

    @Test
    void three() {
        TreeNode root = new TreeNode(1);

        List<Integer> expected = Arrays.asList(1);

        assertEquals(expected, runSolution(root));
    }

    @Test
    void four() {
        TreeNode l = new TreeNode(2);
        TreeNode root = new TreeNode(1, l, null);

        List<Integer> expected = Arrays.asList(2,1);

        assertEquals(expected, runSolution(root));
    }

    @Test
    void five() {
        TreeNode r = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, r);

        List<Integer> expected = Arrays.asList(1,2);

        assertEquals(expected, runSolution(root));
    }
}