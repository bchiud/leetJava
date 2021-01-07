package com.bradychiu;

import com.bradychiu.common.ListNode;

public class ReverseLinkedList {
    /**
     * time: L
     * space: 1
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    /**
     * time: L
     * space: L
     */
    public static ListNode reverseListRecursive(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        return reverseListRecursive(prev, curr);
    }

    private static ListNode reverseListRecursive(ListNode prev, ListNode curr) {
        if (curr == null)
            return prev;

        ListNode temp = curr.next;
        curr.next = prev;

        return reverseListRecursive(curr, temp);
    }
}
