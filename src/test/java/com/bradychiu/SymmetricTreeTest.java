package com.bradychiu;

import com.bradychiu.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymmetricTreeTest {

    private static boolean runSolution(TreeNode root) {
        // return SymmetricTree.isSymmetricIterative(root);
        return SymmetricTree.isSymmetricRecursive(root);
    }

    @Test
    void one() {
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(3);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(2, rl, rr);
        TreeNode root = new TreeNode(1, l ,r);

        assertEquals(true, runSolution(root));
    }

    @Test
    void two() {
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(3);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2, rl, rr);
        TreeNode root = new TreeNode(1, l ,r);

        assertEquals(false, runSolution(root));
    }

    @Test
    void three() {
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(3);
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(3);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(2, rl, rr);
        TreeNode root = new TreeNode(1, l ,r);

        assertEquals(false, runSolution(root));
    }

}