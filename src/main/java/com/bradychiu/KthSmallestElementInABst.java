package com.bradychiu;

import java.util.Stack;

public class KthSmallestElementInABst {

    // time: n^2
    // space: n / 2
    public static int kthSmallestDfsRecursiveDouble(TreeNode root, int k) {
        int leftNodes = countNodes(root.left);

        if (k <= leftNodes)
            return kthSmallestDfsRecursiveDouble(root.left, k);
        else if (k > leftNodes + 1)
            return kthSmallestDfsRecursiveDouble(root.right, k - leftNodes - 1);

        return root.val;
    }

    private static int countNodes(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // time: n
    // space: 1
    private static int count = 0;
    private static int val = Integer.MIN_VALUE;

    public static int kthSmallestDfsRecursiveInOrder(TreeNode root, int k) {
        traverseInOrder(root, k);
        return val;
    }

    private static void traverseInOrder(TreeNode node, int k) {
        if (node == null)
            return;

        traverseInOrder(node.left, k);

        count++;
        if (count == k)
            val = node.val;

        traverseInOrder(node.right, k);
    }

    // time: n
    // * best case is balanced tree going down to a leaf and popping k nodes
    // * worst case is unbalanced tree all skewed left, so stack contains all nodes
    // space: n
    // * best case is balanced tree, so stack only has height of tree, aka log(n)
    // * worst case is all nodes are skewed one way, so stack contains all nodes
    public static int kthSmallestDfsIterativeInOrder(TreeNode root, int k) {
        Stack<TreeNode> dfs = new Stack<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !dfs.isEmpty()) {
            if (current != null) {
                dfs.push(current);
                current = current.left;
            } else {
                TreeNode assess = dfs.pop();
                if (++count == k)
                    return assess.val;
                current = assess.right;
            }
        }

        return Integer.MIN_VALUE;
    }
}
