package com.bradychiu;

import com.bradychiu.common.ListNode;

public class DeleteNodeInLinkedList {
    // linked list mock modified from http://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/

    static void printResults() {
        /*
        amu's comment:
        Try running through the following situation
        (reference of node, value of node)

        List l = [(1,1),(2,1),(3,1)]
        Node n = l.get(0);
        l.deleteNode(n)
        l.deleteNode(n)

        Whats in the list?
        */

        System.out.println(new StringBuilder()
                .append("Delete Node in Linked List: "));

        DeleteNodeInLinkedList llist = new DeleteNodeInLinkedList();

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);

        System.out.println("Created Linked List is: ");
        llist.printList();

        System.out.println("Delete Node in Linked List: ");
        ListNode n = llist.get(1);
        llist.deleteNodeOriginal(n);
        llist.printList();
        llist.deleteNodeOriginal(n);
        llist.printList();
    }

    ListNode head;  // head of list

    /* Linked list Node*/
    // class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode(int x) { val = x; }
    // }

    /* Inserts a new Node at front of the list. */
    void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void deleteNodeOriginal(ListNode node) {
        ListNode previousNode = head;

        if(head == node) {
            head = head.next;
        } else {
            while(previousNode.next != null) {
                if(previousNode.next == node) {
                    previousNode.next = node.next;
                    break;
                }
                previousNode = previousNode.next;
            }
        }
    }

    void deleteNodeOptimal(ListNode node) {
        // copy next node to current node and delete next node
        // since next node no longer has a reference, garbage collection will delete it
        // this answer is not correct b/c if called 1+n times, the node and following n nodes will be deleted
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /* Given a reference (pointer to pointer) to the head of a list
       and a position, deletes the node at the given position */
    // void deleteNode(int position) {
    //     // If linked list is empty
    //     if (head == null)
    //         return;
    //
    //     // Store head node
    //     ListNode temp = head;
    //
    //     // If head needs to be removed
    //     if (position == 0) {
    //         head = temp.next;   // Change head
    //         return;
    //     }
    //
    //     // Find previous node of the node to be deleted
    //     for (int i=0; temp!=null && i<position-1; i++)
    //         temp = temp.next;
    //
    //     // If position is more than number of ndoes
    //     if (temp == null || temp.next == null)
    //         return;
    //
    //     // Node temp->next is the node to be deleted
    //     // Store pointer to the next of node to be deleted
    //     ListNode next = temp.next.next;
    //
    //     temp.next = next;  // Unlink the deleted node from list
    // }

    /* This function prints contents of linked list starting from
        the given node */
    void printList() {
        ListNode tnode = head;
        StringBuilder printSB = new StringBuilder();
        while (tnode != null) {
            printSB.append(tnode.val).append(" ");
            tnode = tnode.next;
        }
        System.out.println(printSB.toString());
    }

    ListNode get(int position) {
        ListNode currentNode = head;

        for(int i = 0; i < position; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
