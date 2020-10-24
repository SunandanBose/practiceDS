package com.sunandan.LinkedList;

public class OddEvenCycle {

    public Node oddEvenList(Node head) {
        if(head == null || head.next == null) return head;
        Node oddHead = head;
        Node evenHead = oddHead.next;
        Node even = evenHead;
        while(evenHead != null && evenHead.next != null){
            oddHead.next = evenHead.next;
            oddHead = oddHead.next;
            if(oddHead != null){
                evenHead.next = oddHead.next;
                evenHead = evenHead.next;
            }
        }
        oddHead.next = even;
        return head;
    }
}
