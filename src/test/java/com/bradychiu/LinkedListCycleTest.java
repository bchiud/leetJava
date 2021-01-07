package com.bradychiu;

import com.bradychiu.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

    private static boolean runSolution(ListNode head) {
        // return LinkedListCycle.hasCycleHashSet(head);
        return LinkedListCycle.hashCyclePointers(head);
    }

    @Test
    void one() {
        ListNode a4 = new ListNode(-4);
        ListNode a3 = new ListNode(0, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(3, a2);
        a4.next = a2;

        assertEquals(true, runSolution(a1));
    }

    @Test
    void two() {
        ListNode a2 = new ListNode(2);
        ListNode a1 = new ListNode(1, a2);
        a2.next = a1;

        assertEquals(true, runSolution(a1));
    }

    @Test
    void three() {
        ListNode a1 = new ListNode(1);

        assertEquals(false, runSolution(a1));
    }

}