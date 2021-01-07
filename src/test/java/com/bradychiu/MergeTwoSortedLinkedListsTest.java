package com.bradychiu;

import com.bradychiu.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeTwoSortedLinkedListsTest {
    private static ListNode runSolution(ListNode l1, ListNode l2) {
        return MergeTwoSortedLinkedLists.mergeTwoLists(l1, l2);
    }

    @Test
    void one() {
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(3, b3);
        ListNode b1 = new ListNode(1, b2);

        ListNode e6 = new ListNode(4);
        ListNode e5 = new ListNode(4, e6);
        ListNode e4 = new ListNode(3, e5);
        ListNode e3 = new ListNode(2, e4);
        ListNode e2 = new ListNode(1, e3);
        ListNode e1 = new ListNode(1, e2);

        assertTrue(linkedListEquals(e1, runSolution(a1, b1)));
    }

    @Test
    void two() {
        ListNode a1 = null;

        ListNode b1 = null;

        ListNode e1 = null;

        assertTrue(linkedListEquals(e1, runSolution(a1, b1)));
    }

    @Test
    void three() {
        ListNode a1 = null;

        ListNode b1 = new ListNode(0);

        ListNode e1 = new ListNode(0);

        assertTrue(linkedListEquals(e1, runSolution(a1, b1)));
    }

    private static boolean linkedListEquals(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA.val != headB.val)
                return false;
            headA = headA.next;
            headB = headB.next;
        }

        return headA == null && headB == null;
    }

}