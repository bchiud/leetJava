package com.bradychiu;

import com.bradychiu.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateBinarySearchTreeTest {

    private static boolean runSolution(TreeNode root) {
        // return ValidateBinarySearchTree.isValidBSTRecursive(root);
        return ValidateBinarySearchTree.isValidBSTIterative(root);
    }

    @Test
    void one() {
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        TreeNode root = new TreeNode(2, l, r);

        assertEquals(true, runSolution(root));
    }

    @Test
    void two() {
        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(6);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(4, rl, rr);
        TreeNode root = new TreeNode(5, l, r);

        assertEquals(false, runSolution(root));
    }

    @Test
    void three() {
        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(6, rl, rr);
        TreeNode root = new TreeNode(5, l, r);

        assertEquals(false, runSolution(root));
    }
}