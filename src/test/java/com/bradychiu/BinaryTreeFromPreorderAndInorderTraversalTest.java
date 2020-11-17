package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeFromPreorderAndInorderTraversalTest {

    private TreeNode runSolution(int[] preorder, int[] inorder) {
        // return BinaryTreeFromPreorderAndInorderTraversal.buildTreeRecursive(preorder, inorder);
        return BinaryTreeFromPreorderAndInorderTraversal.buildTreeIterative(preorder, inorder);
    }

    @Test
    void one() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode l = new TreeNode(9);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        assert(identicalTrees(root, runSolution(preorder, inorder)));
    }

    @Test
    void two() {
        int[] preorder = new int[]{1, 2, 4, 8, 9, 10, 11, 5, 3, 6, 7};
        int[] inorder = new int[]{8, 4, 10, 9, 11, 2, 5, 1, 6, 3, 7};

        TreeNode llrl = new TreeNode(10);
        TreeNode llrr = new TreeNode(11);
        TreeNode lll = new TreeNode(8);
        TreeNode llr = new TreeNode(9, llrl, llrr);
        TreeNode ll = new TreeNode(4, lll, llr);
        TreeNode lr = new TreeNode(5);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode root = new TreeNode(1, l, r);

        assert(identicalTrees(root, runSolution(preorder, inorder)));
    }

    @Test
    void three() {
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 1, 3};

        TreeNode r = new TreeNode(3);
        TreeNode l = new TreeNode(2);
        TreeNode root = new TreeNode(1, l, r);

        assert(identicalTrees(root, runSolution(preorder, inorder)));
    }

    @Test
    void four() {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3, 7};

        TreeNode rr = new TreeNode(7);
        TreeNode rl = new TreeNode(6);
        TreeNode lr = new TreeNode(5);
        TreeNode ll = new TreeNode(4);
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        assert(identicalTrees(root, runSolution(preorder, inorder)));
    }

    boolean identicalTrees(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a != null && b != null)
            return a.val == b.val
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right);

        return false;
    }

}