package com.bradychiu;

import com.bradychiu.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeLinkedListTest {

    private static boolean runSolution(ListNode head) {
        return PalindromeLinkedList.isPalindrome(head);
    }

    @Test
    void one() {
        ListNode a2 = new ListNode(2);
        ListNode a1 = new ListNode(1, a2);

        assertEquals(false, runSolution(a1));
    }

    @Test
    void two() {
        ListNode a4 = new ListNode(1);
        ListNode a3 = new ListNode(2, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        assertEquals(true, runSolution(a1));
    }

    @Test
    void three() {
        ListNode a5 = new ListNode(1);
        ListNode a4 = new ListNode(2, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        assertEquals(true, runSolution(a1));
    }

}