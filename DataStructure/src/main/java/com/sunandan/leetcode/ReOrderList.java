package com.sunandan.leetcode;

public class ReOrderList {

    public void reorderList(LinkedNode head) {
        if (head == null || head.next == null)
            return;

        // 1. Middle of the list
        LinkedNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse Second Half List
        LinkedNode preMiddle = slow;
        LinkedNode preCurrent = slow.next;
        while (preCurrent.next != null) {
            LinkedNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // 3. Merge Alternate Nodes
        slow = head;
        fast = preMiddle.next;
        while (slow != preMiddle) {
            preMiddle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = preMiddle.next;
        }
    }

}
