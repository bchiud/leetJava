package com.bradychiu;

import com.bradychiu.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeDeserializeBinaryTreeTest {

    @Test
    void oneSerializeBfsIterative() {
        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        String expected = "1,2,3,null,null,4,5,null,null,null,null";

        assertEquals(expected, SerializeDeserializeBinaryTree.serializeBfsIterative(root));
    }

    @Test
    void oneDeserializeBfsIterative() {
        String input = "1,2,3,null,null,4,5";

        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        assert equalsTreeNode(root, SerializeDeserializeBinaryTree.deserializeBfsIterative(input));
    }

    @Test
    void twoDeserializeBfsIterative() {
        String input = "1,2,3,null,null,4,5,6,7";

        TreeNode rlr = new TreeNode(7);
        TreeNode rll = new TreeNode(6);
        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4, rll, rlr);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l ,r );

        assert equalsTreeNode(root, SerializeDeserializeBinaryTree.deserializeBfsIterative(input));
    }


    @Test
    void oneSerializeDfsRecursive() {
        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        String expected = "1,2,null,null,3,4,null,null,5,null,null";

        assertEquals(expected, SerializeDeserializeBinaryTree.serializeDfsRecursive(root));
    }

    @Test
    void oneDeserializeDfsRecursive() {
        String input = "1,2,null,null,3,4,null,null,5,null,null";

        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        assert equalsTreeNode(root, SerializeDeserializeBinaryTree.deserializeDfsRecursive(input));
    }

    @Test
    void twoDeserializeDfsRecursive() {
        String input = "1,2,null,null,3,4,6,null,null,7,null,null,5,null,null";

        TreeNode rlr = new TreeNode(7);
        TreeNode rll = new TreeNode(6);
        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4, rll, rlr);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l ,r );

        assert equalsTreeNode(root, SerializeDeserializeBinaryTree.deserializeDfsRecursive(input));
    }


    @Test
    void oneSerializeDfsIterative() {
        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        String expected = "1,2,null,null,3,4,null,null,5,null,null";

        assertEquals(expected, SerializeDeserializeBinaryTree.serializeDfsRecursive(root));
    }

    @Test
    void oneDeserializeDfsIterative() {
        String input = "1,2,null,null,3,4,null,null,5,null,null";

        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l, r);

        assert equalsTreeNode(root, SerializeDeserializeBinaryTree.deserializeDfsRecursive(input));
    }

    @Test
    void twoDeserializeDfsIterative() {
        String input = "1,2,null,null,3,4,6,null,null,7,null,null,5,null,null";

        TreeNode rlr = new TreeNode(7);
        TreeNode rll = new TreeNode(6);
        TreeNode rr = new TreeNode(5);
        TreeNode rl = new TreeNode(4, rll, rlr);
        TreeNode lr = null;
        TreeNode ll = null;
        TreeNode r = new TreeNode(3, rl, rr);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode root = new TreeNode(1, l ,r );

        assert equalsTreeNode(root, SerializeDeserializeBinaryTree.deserializeDfsRecursive(input));
    }


    private static boolean equalsTreeNode(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null)
            return a.val == b.val
                    && equalsTreeNode(a.left, b.left)
                    && equalsTreeNode(a.right, b.right);
        return false;
    }
}