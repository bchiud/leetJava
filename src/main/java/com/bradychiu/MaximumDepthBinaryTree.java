package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
    /**
     * time: n
     * space: n
     */
    public static int maxDepthRecursion(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right)) + 1;
    }

    /**
     * time:
     * space:
     */
    public static int maxDepthIterative(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Integer> depths = new LinkedList<>();
        depths.add(1);
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        int maxDepth = 0;
        while (!bfs.isEmpty()) {
             TreeNode curr = bfs.poll();
             int currDepth = depths.poll();

             if (curr != null) {
                 maxDepth = Math.max(maxDepth, currDepth);
                 depths.add(currDepth + 1);
                 depths.add(currDepth + 1);
                 bfs.add(curr.left);
                 bfs.add(curr.right);
             }
        }

        return maxDepth;
    }

}
