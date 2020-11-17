package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementInABstTest {

    private int runSolution(TreeNode root, int k) {
        // return KthSmallestElementInABst.kthSmallestDfsRecursiveDouble(root, k);
        return KthSmallestElementInABst.kthSmallestDfsRecursiveInOrder(root, k);
        // return KthSmallestElementInABst.kthSmallestDfsIterativeInOrder(root, k);
    }

    @Test
    void one() {
        TreeNode lr = new TreeNode(2);
        TreeNode r = new TreeNode(4);
        TreeNode l = new TreeNode(1, null, lr);
        TreeNode root = new TreeNode(3, l, r);

        assertEquals(1, runSolution(root, 1));
    }

    @Test
    void two() {
        TreeNode lll = new TreeNode(1);
        TreeNode lr = new TreeNode(4);
        TreeNode ll = new TreeNode(2, lll, null);
        TreeNode r = new TreeNode(6);
        TreeNode l = new TreeNode(3, ll, lr);
        TreeNode root = new TreeNode(5, l, r);

        assertEquals(3, runSolution(root, 3));
    }

    @Test
    void three() {
        TreeNode r = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, r);

        assertEquals(2, runSolution(root, 2));
    }
}