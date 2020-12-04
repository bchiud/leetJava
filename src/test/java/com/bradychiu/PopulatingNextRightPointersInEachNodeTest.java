package com.bradychiu;

import com.bradychiu.common.Node;
import org.junit.jupiter.api.Test;

class PopulatingNextRightPointersInEachNodeTest {

    private Node runSolution(Node root) {
        // return PopulatingNextRightPointersInEachNode.connectRecursive(root);
        return PopulatingNextRightPointersInEachNode.connectIterative(root);
    }

    @Test
    void one() {
        Node er = new Node(3);
        Node el = new Node(2, null, null, er);
        Node eroot = new Node(1, el, er);

        Node ar = new Node(3);
        Node al = new Node(2);
        Node aroot = new Node(1, al, ar);

        assert(identicalTrees(eroot, runSolution(aroot)));
    }

    @Test
    void two() {
        Node err = new Node(7);
        Node erl = new Node(6, null, null, err);
        Node elr = new Node(5, null, null, erl);
        Node ell = new Node(4, null, null, elr);
        Node er = new Node(3, erl, err, null);
        Node el = new Node(2, ell, elr, er);
        Node eroot = new Node(1, el, er, null);

        Node arr = new Node(7);
        Node arl = new Node(6);
        Node alr = new Node(5);
        Node all = new Node(4);
        Node ar = new Node(3, arl, arr);
        Node al = new Node(2, all, alr);
        Node aroot = new Node(1, al, ar);

        assert(identicalTrees(eroot, runSolution(aroot)));
    }

    private boolean identicalTrees(Node a, Node b) {
        if (a == null && b == null)
            return true;

        if (a != null && b != null)
            return a.val == b.val
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right)
                    && identicalTrees(a.next, b.next);

        return false;
    }
}