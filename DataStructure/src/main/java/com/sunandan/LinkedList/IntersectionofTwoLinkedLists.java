package com.sunandan.LinkedList;

public class IntersectionofTwoLinkedLists {

    public Node getIntersectionNode(Node headA, Node headB) {
        Node head1 = headA, head2 = headB;
        while (head1 != head2) {
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
        }
        return head1;
    }

}
