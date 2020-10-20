package com.sunandan.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CycleTest {

    private  Cycle cycle = new Cycle();

    @Test
    public void testHasCycle() {
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        Node node1 = new Node(3);
        node.next = node1;
        Node node2 = new Node(4);
        node1.next = node2;
        node2.next = node;
        assertEquals(true, cycle.hasCycle(head));
    }

    @Test
    public void testDetectCycle() {
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        Node node1 = new Node(3);
        node.next = node1;
        Node node2 = new Node(4);
        node1.next = node2;
        node2.next = node;
        assertEquals(node, cycle.detectCycle(head));
    }
}