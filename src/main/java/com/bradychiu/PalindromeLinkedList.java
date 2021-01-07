package com.bradychiu;

import com.bradychiu.common.ListNode;

public class PalindromeLinkedList {

    /**
     * time: n
     * space: 1
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        // find midpoint
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // rev 2nd half
        slow.next = reverseLinkedList(slow.next);

        // check for palindrome
        ListNode left = head;
        ListNode right = slow.next;
        boolean ans = true;
        while (ans && right != null) {
            if (left.val != right.val)
                ans = false;
            left = left.next;
            right = right.next;
        }

        // re-rev 2nd half
        slow.next = reverseLinkedList(slow.next);

        return ans;
    }

    private static ListNode reverseLinkedList(ListNode head) {
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
}
