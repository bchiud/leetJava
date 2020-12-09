package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeDeserializeBinaryTree {

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74260/Recursive-DFS-Iterative-DFS-and-BFS

    private static final String DELIMITER = ",";
    private static final String NULL_STR = "null";

    /**
     * Level order traversal
     * time: n
     * space: n
     */
    //
    public static String serializeBfsIterative(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        StringBuilder sb = new StringBuilder();

        while (!bfs.isEmpty()) {
            TreeNode cur = bfs.poll();
            sb.append(cur == null ? NULL_STR : String.valueOf(cur.val));

            if (cur != null) {
                bfs.add(cur.left);
                bfs.add(cur.right);
            }
            if (bfs.size() > 0) {
                sb.append(DELIMITER);
            }
        }

        return sb.toString();
    }

    /**
     * Level order traversal
     * Decodes your encoded data to tree.
     * time: n
     * space: n
     */
    public static TreeNode deserializeBfsIterative(String data) {
        if (data == "")
            return null;

        String[] nums = data.split(DELIMITER);

        Queue<TreeNode> bfs = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        bfs.add(root);
        TreeNode parent = root;

        for (int i = 1; i < nums.length; i++) {
            TreeNode child = nums[i].equals(NULL_STR) ? null :  new TreeNode(Integer.parseInt(nums[i]));

            if (i % 2 == 1) { // i also == count of existing nodes
                parent = bfs.poll();
                if (child != null)
                    parent.left = child;
            } else {
                if (child != null)
                    parent.right = child;
            }
            if (child != null)
                bfs.add(child);
        }

        return root;
    }

    /**
     * Preorder traversal
     * time: n
     * space: n
     */

    public static String serializeDfsRecursive(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        serializeDfsHelper(root, sb);
        return sb.substring(0, sb.length() - 1).toString();

    }

    private static void serializeDfsHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_STR).append(DELIMITER);
            return;
        } else {
            sb.append(String.valueOf(node.val)).append(DELIMITER);
            serializeDfsHelper(node.left, sb);
            serializeDfsHelper(node.right, sb);
        }
    }

    /**
     * Preorder traversal
     * time: n
     * space: n
     */

    public static TreeNode deserializeDfsRecursive(String data) {
        if (data == "")
            return null;

        Queue<String> strings = new LinkedList<>();
        strings.addAll(Arrays.asList(data.split(DELIMITER)));
        return deserializeDfsHelper(strings);

    }

    private static TreeNode deserializeDfsHelper(Queue<String> strings) {
        String val = strings.poll();
        if (val.equals(NULL_STR))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeDfsHelper(strings);
            node.right = deserializeDfsHelper(strings);
            return node;
        }
    }

    /**
     * Preorder traversal
     * time: n
     * space: n
     */
    public static String serializeDfsIterative(TreeNode root) {
        if (root == null)
            return "";

        Stack<TreeNode> dfs = new Stack<>();
        dfs.add(root);

        StringBuilder sb = new StringBuilder();

        while(!dfs.isEmpty()) {
            TreeNode cur = dfs.pop();
            if (cur == null) {
                sb.append(NULL_STR).append(DELIMITER);
            } else {
                sb.append(String.valueOf(cur.val)).append(DELIMITER);
                dfs.add(cur.right);
                dfs.add(cur.left);
            }
        }

        return sb.substring(0, sb.length() - 1).toString();
    }

    /**
     * Preorder traversal
     * time: n
     * space: n
     */
    public static TreeNode deserializeDfsIterative(String data) {
        if (data == "")
            return null;

        String[] nums = data.split(DELIMITER);

        Stack<TreeNode> dfs = new Stack<>();
        TreeNode preHead = new TreeNode();
        TreeNode curr = preHead;

        for (String val : nums) {
            TreeNode next = val.equals(NULL_STR) ? null : new TreeNode(Integer.parseInt(val));

            if (curr != null) {
                curr.left = next;
                dfs.push(curr);
                curr = curr.left;
            } else {
                curr = dfs.pop();
                curr.right = next;
                curr = curr.right;
            }
        }

        return preHead.left;
    }
}
