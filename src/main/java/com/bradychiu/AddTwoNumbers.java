package com.bradychiu;

public class AddTwoNumbers {

    // https://leetcode.com/problems/add-two-numbers/

    static void printResults() {
        ListNode a1 = new ListNode(2),
                a2 = new ListNode(4),
                a3 = new ListNode(3),
                b1 = new ListNode(5),
                b2 = new ListNode(6),
                b3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;

        ListNode c1 = new ListNode(2),
                c2 = new ListNode(4),
                c3 = new ListNode(3),
                d1 = new ListNode(5),
                d2 = new ListNode(6),
                d3 = new ListNode(4),
                d4 = new ListNode(4);

        c1.next = c2;
        c2.next = c3;
        d1.next = d2;
        d2.next = d3;
        d3.next = d4;

        ListNode e1 = new ListNode(5),
                f1 = new ListNode(5);

        System.out.println(new StringBuilder()
                .append("Add Two Numbers Original: ")
                .append(stringLinkedList(addTwoNumbersOriginal(a1, b1)))
                .toString());
        // System.out.println(new StringBuilder()
        //         .append("Add Two Numbers Optimal: ")
        //         .append(printLinkedList(addTwoNumbersOpimal(a1, b1)))
        //         .toString());
        System.out.println(new StringBuilder()
                .append("Add Two Numbers Original: ")
                .append(stringLinkedList(addTwoNumbersOriginal(c1, d1)))
                .toString());
        // System.out.println(new StringBuilder()
        //         .append("Add Two Numbers Optimal: ")
        //         .append(printLinkedList(addTwoNumbersOpimal(c1, d1)))
        //         .toString());
        System.out.println(new StringBuilder()
                .append("Add Two Numbers Original: ")
                .append(stringLinkedList(addTwoNumbersOriginal(e1, f1)))
                .toString());
        // System.out.println(new StringBuilder()
        //         .append("Add Two Numbers Optimal: ")
        //         .append(stringLinkedList(addTwoNumbersOpimal(e1, f1)))
        //         .toString());
    }

    // generic stuff

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static String stringLinkedList(ListNode n) {
        ListNode currentNode = n;

        StringBuilder sb = new StringBuilder();
        while(currentNode != null) {
            sb.append(currentNode.val).append(" ");
            currentNode = currentNode.next;
        }

        return sb.toString();
    }

    // leetcode response

    static ListNode addTwoNumbersOriginal(ListNode l1, ListNode l2) {
        ListNode currentOneNode = l1;
        ListNode currentTwoNode = l2;

        int total = l1.val + l2.val;
        int carry = total > 9 ? 1 : 0;

        ListNode head = new ListNode(total % 10);
        ListNode currentResultNode = head;

        while(currentOneNode.next != null | currentTwoNode.next != null | carry == 1) {
            ListNode dummy = new ListNode(0);
            currentResultNode.next = dummy;

            total = carry +
                    ( currentOneNode.next != null ? currentOneNode.next.val : 0 ) +
                    ( currentTwoNode.next != null ? currentTwoNode.next.val : 0 );
            carry = total > 9 ? 1 : 0;
            dummy.val = total > 9 ? total % 10 : total;

            currentOneNode = currentOneNode.next != null ? currentOneNode.next : new ListNode(0);
            currentTwoNode = currentTwoNode.next != null ? currentTwoNode.next : new ListNode(0);
            currentResultNode = currentResultNode.next;
        }

        return head;
    }

    static ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}
