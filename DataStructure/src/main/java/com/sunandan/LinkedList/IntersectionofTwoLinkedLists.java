package com.sunandan.LinkedList;

public class IntersectionofTwoLinkedLists {
    // raj: Another solution is to put all elemnts in a new map while iterating list1
    // Iterate over list2 and check the map
    // Return if match or else exit
    
    public Node getIntersectionNode(Node headA, Node headB) {
        Node head1 = headA, head2 = headB;
        while (head1 != head2) {
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
        }
        return head1;
    }

}
