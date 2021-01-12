package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * time: n
     * space: n
     */
    public static List<List<Integer>> levelOrderBfsIterative(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        int level = 0;
        while (!bfs.isEmpty()) {
            ans.add(new ArrayList<>());
            int levelSize = bfs.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = bfs.poll();

                ans.get(level).add(curr.val);

                if (curr.left != null)
                    bfs.add(curr.left);
                if (curr.right != null)
                    bfs.add(curr.right);
            }

            level++;
        }

        return ans;
    }

    /**
     * time: n
     * space: n
     */
    public static List<List<Integer>> levelOrderDfsRecursion(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> output = new ArrayList<>();
        helper(output, root, 0);
        return output;
    }

    private static void helper(List<List<Integer>> output, TreeNode root, int level) {
        if (root == null)
            return;

        if (output.size() <= level)
            output.add(new ArrayList<>());

        output.get(level).add(root.val);
        helper(output, root.left, level + 1);
        helper(output, root.right, level + 1);
    }
}
