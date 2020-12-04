package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inOrderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> dfs = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !dfs.isEmpty()) {
            while(cur != null) {
                dfs.push(cur);
                cur = cur.left;
            }
            cur = dfs.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }


    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        if (root.left != null)
            result.addAll(inorderTraversalRecursive(root.left));
        result.add(root.val);
        if (root.right != null)
            result.addAll(inorderTraversalRecursive(root.right));

        return result;
    }


}
