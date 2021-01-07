package com.bradychiu;

import com.bradychiu.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static boolean hasCycleHashSet(ListNode head) {
        Set<ListNode> hashTable = new HashSet<>();
        while (head != null) {
            if (hashTable.contains(head))
                return true;
            else
                hashTable.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hashCyclePointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
