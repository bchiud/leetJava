package com.bradychiu;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode(0);
        ListNode current = preHead;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(carry % 10);
            carry /= 10;
            current = current.next;
        }

        return preHead.next;
    }

    public static ListNode addTwoNumbersOriginal(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = head;
        ListNode dummy = new ListNode(0);

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int newVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            carry = newVal / 10;

            ListNode newNode = new ListNode(newVal % 10);

            if (head == null) {
                head = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }

            if (l1 == null && l2 == null) {
                break;
            } else if (l1.next != null && l2.next == null) {
                l1 = l1.next;
                l2 = dummy;
            } else if (l1.next == null && l2.next != null)  {
                l1 = dummy;
                l2 = l2.next;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        return head;
    }
}
