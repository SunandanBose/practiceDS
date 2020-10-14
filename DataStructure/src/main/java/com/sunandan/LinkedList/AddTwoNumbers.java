package com.sunandan.LinkedList;

public class AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {
        Node prev = null;
        Node head = null;
        int carry = 0, store = 0, l1Value = 0, l2Value = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) l1Value = 0;
            else l1Value = l1.data;
            if (l2 == null) l2Value = 0;
            else l2Value = l2.data;
            int sum = carry + l1Value + l2Value;
            store = sum % 10;
            carry = sum / 10;
            Node node = new Node(store);
            if (prev != null) prev.next = node;
            else head = node;
            prev = node;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head;
    }

}
