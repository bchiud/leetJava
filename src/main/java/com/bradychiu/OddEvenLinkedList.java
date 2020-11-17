package com.bradychiu;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddsCurrent = head;
        ListNode evensCurrent = head.next;
        ListNode evensHead = evensCurrent;

        while (evensCurrent != null && evensCurrent.next != null) {
            oddsCurrent.next = evensCurrent.next;
            oddsCurrent = oddsCurrent.next;

            evensCurrent.next = oddsCurrent.next;
            evensCurrent = evensCurrent.next;
        }

        oddsCurrent.next = evensHead;

        return head;
    }

    public static ListNode oddEvenListOriginal(ListNode head) {
        if (head == null)
            return head;

        boolean oddPos = true;
        ListNode current = head;
        ListNode oddLast = null;
        ListNode evenHead = null;
        ListNode evenLast = null;

        while (current != null) {
            if (oddPos) {
                if (oddLast != null) {
                    oddLast.next = current;
                }
                oddLast = current;
            } else {
                if (evenHead == null) {
                    evenHead = current;
                } else {
                    evenLast.next = current;
                }
                evenLast = current;
            }

            oddPos = !oddPos;
            current = current.next;
        }

        if (evenHead != null) {
            oddLast.next = evenHead;
            evenLast.next = null;
        }

        return head;
    }
}
