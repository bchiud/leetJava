package com.bradychiu;

import com.bradychiu.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeFromPreorderAndInorderTraversal {

    // inOrder : Left Root Right
    // preOrder : Root Left Right       1 2 4 5 3 6 7
    // postOrder : Left Right Root

    // time: n
    // space: n
    public static TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        TreeNode root = buildTreeRecursive(preorder, 0, preorder.length - 1,
                inMap, 0, inorder.length - 1);

        return root;
    }

    private static TreeNode buildTreeRecursive(int[] preorder, int preStart, int preEnd,
                                               Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeRecursive(preorder, preStart + 1, preStart + numsLeft,
                inMap, inStart, inRoot - 1);
        root.right = buildTreeRecursive(preorder, preStart + numsLeft + 1, preEnd,
                inMap, inRoot + 1, inEnd);

        return root;
    }

    // time: 2n
    // space: n
    public static TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int preOrderIndex = 1;
        int inOrderIndex = 0;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            TreeNode node;


            if (top.val != inorder[inOrderIndex]) {
                node = new TreeNode(preorder[preOrderIndex++]);
                top.left = node;
            } else if (++inOrderIndex == inorder.length) {
                break;
            } else {
                stack.pop();
                if (!stack.isEmpty() && (stack.peek().val == inorder[inOrderIndex]))
                    continue;

                node = new TreeNode(preorder[preOrderIndex++]);
                top.right = node;
            }

            stack.push(node);
        }

        return root;
    }

}
