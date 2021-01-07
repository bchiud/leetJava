package com.bradychiu;

import com.bradychiu.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReverseLinkedListTest {

    private static ListNode runSolution(ListNode head) {
        return ReverseLinkedList.reverseList(head);
        // return ReverseLinkedList.reverseListRecursive(head);
    }

    @Test
    void one() {
        ListNode a5 = new ListNode(5);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode e5 = new ListNode(1);
        ListNode e4 = new ListNode(2, e5);
        ListNode e3 = new ListNode(3, e4);
        ListNode e2 = new ListNode(4, e3);
        ListNode e1 = new ListNode(5, e2);

        assertTrue(linkedListEquals(e1, runSolution(a1)));
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