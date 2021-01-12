package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.Stack;

public class ConvertSortedArrayToBinaryTree {
    /**
     * time: n
     * space: n
     */
    public static TreeNode sortedArrayToBSTPreOrderRecursive(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return sortedArrayToBSTPreOrderIterativeHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTPreOrderIterativeHelper(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2; // this chooses left mid
        // if ((left + right) % 2 == 1) // this chooses right mid
        //     mid++;

        TreeNode head = new TreeNode(nums[mid]);
        head.left = sortedArrayToBSTPreOrderIterativeHelper(nums, left, mid - 1);
        head.right = sortedArrayToBSTPreOrderIterativeHelper(nums, mid + 1, right);
        return head;
    }

    /**
     * time: n
     * space: n
     */

    public static TreeNode sortedArrayToBSTPreOrderIterative(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        Stack<TreeNode> dfs = new Stack<>();
        Stack<Integer> leftIndexes = new Stack<>();
        Stack<Integer> rightIndexes = new Stack<>();

        TreeNode root = new TreeNode();
        dfs.add(root);
        leftIndexes.add(0);
        rightIndexes.add(nums.length - 1);

        while (!dfs.isEmpty()) {
            TreeNode currNode = dfs.pop();
            int leftIndex = leftIndexes.pop();
            int rightIndex = rightIndexes.pop();
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            currNode.val = nums[midIndex];

            if (leftIndex <= midIndex - 1) {
                currNode.left = new TreeNode();
                dfs.add(currNode.left);
                leftIndexes.add(leftIndex);
                rightIndexes.add(midIndex - 1);
            }
            if (midIndex + 1 <= rightIndex) {
                currNode.right = new TreeNode();
                dfs.add(currNode.right);
                leftIndexes.add(midIndex + 1);
                rightIndexes.add(rightIndex);
            }
        }

        return root;
    }

}
