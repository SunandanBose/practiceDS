package com.sunandan.LinkedList;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class Cycle {

    public boolean hasCycle(Node head) {
        if (head == null) return false;
        Node walker = head;
        Node runner = head.next;
        while (walker != null) {
            if (walker == runner)
                return true;
            if (runner == null || runner.next == null || runner.next.next == null)
                return false;
            walker = walker.next;
            runner = runner.next.next;
        }
        return false;
    }

    public Node detectCycle(Node head) {
        Node walker = head;
        Node runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (runner == walker) {
                runner = head;
                while (runner != walker) {
                    walker = walker.next;
                    runner = runner.next;
                }
                return walker;
            }
        }
        return null;
    }

}
