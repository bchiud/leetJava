package com.bradychiu;

import com.bradychiu.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthBinaryTreeTest {

    private static int runSolution(TreeNode root) {
        // return MaximumDepthBinaryTree.maxDepthRecursion(root);
        return MaximumDepthBinaryTree.maxDepthIterative(root);
    }

    @Test
    void one() {
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        assertEquals(3, runSolution(root));
    }

    @Test
    void two() {
        TreeNode r = new TreeNode(2);
        TreeNode root = new TreeNode(3, null, r);

        assertEquals(2, runSolution(root));
    }

    @Test
    void three() {
        TreeNode root = null;

        assertEquals(0, runSolution(root));
    }

    @Test
    void four() {
        TreeNode root = new TreeNode(1);

        assertEquals(1, runSolution(root));
    }


}