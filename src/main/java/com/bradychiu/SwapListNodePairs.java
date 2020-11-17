package com.bradychiu;

public class SwapListNodePairs {

    ListNode swapPairsOriginal(ListNode head) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(0), previous = dummyHead;
        dummyHead.next = head;
        // TODO: the below is the same as the above 2 lines, does previous and dummyHead occupy the same memory location?
        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next = head;
        // ListNode previous = dummyHead;
        while(previous.next != null && previous.next.next != null) {
            ListNode first = previous.next; // create new 1st node
            previous.next = first.next; // point previous node to 2nd node
            first.next = first.next.next; // point 1st node to 3rd node
            previous.next.next = first; // point 2nd node to first node
            previous = previous.next.next; // go to new 1st node, which is now 2nd position
        }
        return dummyHead.next;
    }


    ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next; // copy 2nd node

        head.next = swapPairsRecursive(newHead.next); // point 1st node to 3rd node

        newHead.next = head; // point 2nd node to 1st node

        return newHead;
    }

     ListNode swapPairsOptimal(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode previous = dummy;
        while(head != null && head.next != null) {
            previous.next = head.next; // point 0th node to 2nd node
            ListNode tmp = head; // create new 1st node
            head = head.next.next; // set 3rd node as new head
            previous.next.next = tmp; // point 2nd node to new 1st node
            previous = previous.next.next; // set 1st node (now 2nd position) as previous to prep for next loop
        }

        previous.next = head != null ? head : null; // point 0th node to head when odd number of nodes
        return dummy.next;
    }

}
