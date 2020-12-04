package com.bradychiu;

import com.bradychiu.common.Node;

public class PopulatingNextRightPointersInEachNode {

    // time: n
    // space: 1
    public static Node connectRecursive(Node root) {
        if (root == null)
            return root;

        setNext(root.left, root.right);

        return root;
    }

    private static void setNext(Node left, Node right) {
        if (left == null && right == null)
            return;

        left.next = right;

        setNext(left.left, left.right);
        setNext(left.right, right.left);
        setNext(right.left, right.right);
    }

    // time: n
    // space: 1
    public static Node connectIterative(Node root) {
        if (root == null)
            return root;

        // outer loop moves down
        // inner loop moves right
        Node vertical = root;
        while (vertical.left != null) {
            Node horizontal = vertical;
            while (horizontal != null) {
                horizontal.left.next = horizontal.right;
                if (horizontal.next != null)
                    horizontal.right.next = horizontal.next.left;
                horizontal = horizontal.next;
            }
            vertical = vertical.left;
        }

        return root;
    }
}
