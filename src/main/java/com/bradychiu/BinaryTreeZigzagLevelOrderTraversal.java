package com.bradychiu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        step(root, result, 0);

        return result;
    }

    // Time: n
    // Space: n
    private static void step(TreeNode cur, List<List<Integer>> result, int level) {
        if (cur == null)
            return;

        if (result.size() <= level)
            result.add(new ArrayList<>());

        if (level % 2 == 0)
            result.get(level).add(cur.val);
        else
            result.get(level).add(0, cur.val);

        step(cur.left, result, level + 1);
        step(cur.right, result, level + 1);
    }

    // Time: n
    // Space: n
    public static List<List<Integer>> zigzagLevelOrderTwoStackAlternating(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        TreeNode cur;
        while (!s1.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            while (!s1.isEmpty()) {
                cur = s1.pop();
                vals.add(cur.val);
                if (cur.left != null)
                    s2.push(cur.left);
                if (cur.right != null)
                    s2.push(cur.right);
            }
            result.add(vals);

            vals = new ArrayList<>();
            while (!s2.isEmpty()) {
                cur = s2.pop();
                vals.add(cur.val);
                if (cur.right != null)
                    s1.push(cur.right);
                if (cur.left != null)
                    s1.push(cur.left);
            }
            if (!vals.isEmpty())
                result.add(vals);
        }

        return result;
    }

    // Time: n
    // Space: n
    public static List<List<Integer>> zigzagLevelOrderTwoStack(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> currRowNodes = new Stack<>();
        Stack<TreeNode> nextRowNodes = new Stack<>();
        int level = 0;

        TreeNode curr = root;
        currRowNodes.push(curr);

        while (!currRowNodes.isEmpty()) {
            // process current row
            List<Integer> currRowVals = new ArrayList<>();
            while (!currRowNodes.isEmpty()) {
                curr = currRowNodes.pop();
                if (level % 2 == 0) {
                    if (curr.left != null)
                        nextRowNodes.push(curr.left);
                    if (curr.right != null)
                        nextRowNodes.push(curr.right);
                } else {
                    if (curr.right != null)
                        nextRowNodes.push(curr.right);
                    if (curr.left != null)
                        nextRowNodes.push(curr.left);
                }

                currRowVals.add(curr.val);
            }
            result.add(currRowVals);

            // go to next row
            currRowNodes = nextRowNodes;
            nextRowNodes = new Stack<>();
            level++;
        }

        return result;
    }
}
