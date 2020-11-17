package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTwoLinkedListsTest {

    // pick which algorithm to run
    private ListNode runSolution(ListNode a, ListNode b) {
        return IntersectionTwoLinkedLists.getIntersectionNode(a, b);
        // return IntersectionTwoLinkedLists.getIntersectionNodeUsingLen(a, b);
    }

    @Test
    void one() {
        ListNode c3 = new ListNode(5);
        ListNode c2 = new ListNode(5, c3);
        ListNode c1 = new ListNode(8, c2);

        ListNode b3 = new ListNode(1, c1);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        ListNode a2 = new ListNode(1, c1);
        ListNode a1 = new ListNode(4, a2);

        assert(c1 == runSolution(a1, b1));
    }

    @Test
    void two() {
        ListNode c2 = new ListNode(4);
        ListNode c1 = new ListNode(2, c2);

        ListNode b1 = new ListNode(3, c1);

        ListNode a3 = new ListNode(1, c1);
        ListNode a2 = new ListNode(9, a3);
        ListNode a1 = new ListNode(1, a2);

        assert(c1 == runSolution(a1, b1));
    }

    @Test
    void three() {
        ListNode b2 = new ListNode(5);
        ListNode b1 = new ListNode(1, b2);

        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(6, a3);
        ListNode a1 = new ListNode(2, a2);

        assert(null == runSolution(a1, b1));
    }

    @Test
    void four() {
        ListNode a1 = null;

        ListNode b1 = null;

        assert(null == runSolution(a1, b1));
    }

}