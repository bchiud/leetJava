package com.bradychiu;

import com.bradychiu.common.ListNode;

public class DeleteNodeInLinkedList {
    /**
     * time: 1
     * space: 1
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
