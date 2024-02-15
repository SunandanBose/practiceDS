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

    // Floyd's Tortoise and Hare algorithm 
    // walker and runner are initialized at the head of the linked list.
    // runner moves twice as fast as walker, detecting if a cycle exists.
    // When runner catches up to walker, a cycle is detected.
    // runner resets to the head, both pointers move at the same pace to find cycle start. (Don't know why after walking slowly, both will meet)
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
