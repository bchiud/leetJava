package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    /**
     * time: n
     * space: n
     */
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> bfsLeft = new LinkedList<>();
        bfsLeft.add(root);
        Queue<TreeNode> bfsRight = new LinkedList<>();
        bfsRight.add(root);

        while (!bfsLeft.isEmpty() || !bfsRight.isEmpty()) {
            TreeNode currLeft = bfsLeft.poll();
            TreeNode currRight = bfsRight.poll();

            if ((currLeft == null && currRight != null)
                    || (currLeft != null && currRight == null))
                return false;

            if (currLeft != null && currRight != null) {
                if (currLeft.val != currRight.val)
                    return false;

                bfsLeft.add(currLeft.left);
                bfsRight.add(currRight.right);
                bfsLeft.add(currLeft.right);
                bfsRight.add(currRight.left);
            }
        }

        return true;
    }

    /**
     * time: n
     * space: n
     */
    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetricRecursiveMatching(root, root);
    }

    private static boolean isSymmetricRecursiveMatching(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val)
                && isSymmetricRecursiveMatching(left.left, right.right)
                && isSymmetricRecursiveMatching(left.right, right.left);
    }
}