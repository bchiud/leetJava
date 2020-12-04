package com.bradychiu;

import com.bradychiu.common.TreeNode;

public class InorderSuccessorBST {

    public static TreeNode inorderSuccessorRecursive(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val)
            return inorderSuccessorRecursive(root.right, p);
        else {
            TreeNode left = inorderSuccessorRecursive(root.left, p);
            return left != null ? left : root;
        }
    }

    /**
     * time: n -> worse case is height of tree == n
     * space: 1
     *
     * 1) if p node has a right subtree, successor would be the smallest note in p's right subtree
     * 2) if p doesn't have a right subtree, it is the last node whose left subtree it is are under
     */
    public static TreeNode inorderSuccessorIterative(TreeNode root, TreeNode p) {
        TreeNode succesor = null;
        while (root != null) {
            if (p.val < root.val) { // If current node's value is greater than p's value, current node is a candidate. Go to its left subtree to see if we can find a smaller candidate.
                succesor = root;
                root = root.left;
            } else { // If current node's value is less than or equal to p's value, we know our answer must be in the right subtree.
                root = root.right;
            }
        }

        return succesor;
    }

    public static TreeNode inorderSuccessorIterativeDetailed(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        // case 1:
        // pre is used to save the last node whose left substree
        TreeNode pre = null;
        // find node p
        while (root.val != p.val) {
            if (p.val < root.val) {
                // only update pre when p.val<root.val
                pre = root;
                root = root.left;
            } else if (p.val > root.val)
                root = root.right;
        }

        // at this point root.val=p.val
        if (root.right == null)
            return pre;
        else {
            // case 2
            TreeNode leftMost = root.right;
            while (leftMost != null) {
                leftMost = leftMost.left;
            }
            return leftMost;
        }
    }
}
