package com.bradychiu;

import com.bradychiu.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConvertSortedArrayToBinaryTreeTest {

    private static TreeNode runSolution(int[] nums) {
        // return ConvertSortedArrayToBinaryTree.sortedArrayToBSTPreOrderRecursive(nums);
        return ConvertSortedArrayToBinaryTree.sortedArrayToBSTPreOrderIterative(nums);
    }

    @Test
    void one() {
        int[] nums = new int[] {-10,-3,0,5,9};

        TreeNode lr = new TreeNode(-3);
        TreeNode rr = new TreeNode(9);
        TreeNode l = new TreeNode(-10, null, lr);
        TreeNode r = new TreeNode(5, null, rr);
        TreeNode root = new TreeNode(0, l, r);

        assertTrue(bstEquals(root, runSolution(nums)));
    }

    private static boolean bstEquals(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        return (a.val == b.val)
                && bstEquals(a.left, b.left)
                && bstEquals(a.right, b.right);
    }
}