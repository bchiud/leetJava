package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {
    /**
     * time: n
     * space: n
     */
    public static boolean isValidBSTRecursive(TreeNode root) {
        return isValidBSTRecursive(root, null, null);
    }

    private static boolean isValidBSTRecursive(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;

        if (low != null && root.val <= low)
            return false;

        if (high != null && high <= root.val)
            return false;

        return isValidBSTRecursive(root.left, low, root.val) && isValidBSTRecursive(root.right, root.val, high);
    }

    /**
     * time: n
     * space: n
     */
    public static boolean isValidBSTIterative(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        Queue<Integer> low = new LinkedList<>();
        low.add(null);
        Queue<Integer> high = new LinkedList<>();
        high.add(null);

        while (!bfs.isEmpty()) {
            TreeNode curr = bfs.poll();
            Integer currLow = low.poll();
            Integer currHigh = high.poll();

            if (curr != null) {
                if (currLow != null && currLow >= curr.val)
                    return false;
                if (currHigh != null && curr.val >= currHigh)
                    return false;

                bfs.add(curr.left);
                low.add(currLow);
                high.add(curr.val);

                bfs.add(curr.right);
                low.add(curr.val);
                high.add(currHigh);
            }
        }

        return true;
    }
}
