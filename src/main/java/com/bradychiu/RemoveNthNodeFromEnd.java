package com.bradychiu;

import com.bradychiu.common.ListNode;

public class RemoveNthNodeFromEnd {
    /**
     * time: L
     * space: 1
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = dummy;
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }

        while(tail.next != null) {
            curr = curr.next;
            tail = tail.next;
        }

        curr.next = curr.next.next;

        return dummy.next;
    }
}
