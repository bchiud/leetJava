package com.bradychiu;

import com.bradychiu.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoveNthNodeFromEndTest {

    private static ListNode runSolution(ListNode head, int n) {
        return RemoveNthNodeFromEnd.removeNthFromEnd(head, n);
    }

    @Test
    void one() {
        ListNode in5 = new ListNode(5);
        ListNode in4 = new ListNode(4, in5);
        ListNode in3 = new ListNode(3, in4);
        ListNode in2 = new ListNode(2, in3);
        ListNode in1 = new ListNode(1, in2);

        ListNode ex4 = new ListNode(5);
        ListNode ex3 = new ListNode(3, ex4);
        ListNode ex2 = new ListNode(2, ex3);
        ListNode ex1 = new ListNode(1, ex2);

        assertTrue(linkedListEquals(ex1, runSolution(in1, 2)));
    }

    @Test
    void two() {
        ListNode in1 = new ListNode(1);

        ListNode ex1 = null;

        assertTrue(linkedListEquals(ex1, runSolution(in1, 1)));
    }

    @Test
    void three() {
        ListNode in2 = new ListNode(2);
        ListNode in1 = new ListNode(1, in2);

        ListNode ex1 = new ListNode(1);

        assertTrue(linkedListEquals(ex1, runSolution(in1, 1)));
    }


    private static boolean linkedListEquals(ListNode nodeA, ListNode nodeB) {
        while (nodeA != null && nodeB != null) {
            if (nodeA.val != nodeB.val)
                return false;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA == null && nodeB == null;
    }
}