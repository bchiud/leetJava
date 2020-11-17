package com.bradychiu;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static boolean linkedListValsEquals(ListNode l1, ListNode l2) {
        while(l1 != null || l2 != null) {
            // System.out.println(l1.val + ", " + l2.val);
            if (l1.val != l2.val) {
                // System.out.println(l1.val + " != " + l2.val);
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    static void printLinkedList(ListNode head) {
        assert head != null;

        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println(head.val);
    }
}
