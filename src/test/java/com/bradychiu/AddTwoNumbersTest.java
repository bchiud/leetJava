package com.bradychiu;

import org.junit.jupiter.api.Test;

import static com.bradychiu.ListNode.linkedListValsEquals;

class AddTwoNumbersTest {

    @Test
    void one() {
        ListNode a3 = new ListNode(3);
        ListNode a2 = new ListNode(4, a3);
        ListNode a1 = new ListNode(2, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        ListNode e3 = new ListNode(8);
        ListNode e2 = new ListNode(0, e3);
        ListNode e1 = new ListNode(7, e2);

        assert(linkedListValsEquals(e1, AddTwoNumbers.addTwoNumbers(a1, b1)));
        assert(linkedListValsEquals(e1, AddTwoNumbers.addTwoNumbersOriginal(a1, b1)));
    }

    @Test
    void two() {
        ListNode a1 = new ListNode(0);

        ListNode b1 = new ListNode(0);

        ListNode e1 = new ListNode(0);

        assert(linkedListValsEquals(e1, AddTwoNumbers.addTwoNumbers(a1, b1)));
        assert(linkedListValsEquals(e1, AddTwoNumbers.addTwoNumbersOriginal(a1, b1)));
    }

    @Test
    void three() {
        ListNode a7 = new ListNode(9);
        ListNode a6 = new ListNode(9, a7);
        ListNode a5 = new ListNode(9, a6);
        ListNode a4 = new ListNode(9, a5);
        ListNode a3 = new ListNode(9, a4);
        ListNode a2 = new ListNode(9, a3);
        ListNode a1 = new ListNode(9, a2);

        ListNode b4 = new ListNode(9);
        ListNode b3 = new ListNode(9, b4);
        ListNode b2 = new ListNode(9, b3);
        ListNode b1 = new ListNode(9, b2);

        ListNode e8 = new ListNode(1);
        ListNode e7 = new ListNode(0, e8);
        ListNode e6 = new ListNode(0, e7);
        ListNode e5 = new ListNode(0, e6);
        ListNode e4 = new ListNode(9, e5);
        ListNode e3 = new ListNode(9, e4);
        ListNode e2 = new ListNode(9, e3);
        ListNode e1 = new ListNode(8, e2);

        assert(linkedListValsEquals(e1, AddTwoNumbers.addTwoNumbers(a1, b1)));
        assert(linkedListValsEquals(e1, AddTwoNumbers.addTwoNumbersOriginal(a1, b1)));
    }
}