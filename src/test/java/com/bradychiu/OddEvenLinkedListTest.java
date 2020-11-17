package com.bradychiu;

import org.junit.jupiter.api.Test;

import static com.bradychiu.ListNode.linkedListValsEquals;
import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {

    // pick which algorithm to run
    private ListNode runSolution(ListNode head) {
        return OddEvenLinkedList.oddEvenList(head);
        // return OddEvenLinkedList.oddEvenListOriginal(head);
    }

    @Test
    void one() {
        ListNode a5 = new ListNode(5);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode e5 = new ListNode(4);
        ListNode e4 = new ListNode(2, e5);
        ListNode e3 = new ListNode(5, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(1, e2);

        assert(linkedListValsEquals(e1, runSolution(a1)));
    }

    @Test
    void two() {
        ListNode a7 = new ListNode(7);
        ListNode a6 = new ListNode(4, a7);
        ListNode a5 = new ListNode(6, a6);
        ListNode a4 = new ListNode(5, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(1, a3);
        ListNode a1 = new ListNode(2, a2);

        ListNode e7 = new ListNode(4);
        ListNode e6 = new ListNode(5, e7);
        ListNode e5 = new ListNode(1, e6);
        ListNode e4 = new ListNode(7, e5);
        ListNode e3 = new ListNode(6, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);

        assert(linkedListValsEquals(e1, runSolution(a1)));
    }

    @Test
    void three() {
        ListNode a1 = null;

        ListNode e1 = null;

        assert(linkedListValsEquals(e1, runSolution(a1)));
    }

    @Test
    void four() {
        ListNode a1 = new ListNode(1);

        ListNode e1 = new ListNode(1);

        assert(linkedListValsEquals(e1, runSolution(a1)));
    }
}