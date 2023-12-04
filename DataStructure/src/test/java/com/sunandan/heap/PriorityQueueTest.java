package com.sunandan.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    PriorityQueue priorityQueue = new PriorityQueue();

    @Test
    public void test1add() {
        priorityQueue.add("t", 2);
        priorityQueue.add("m", 5);
        priorityQueue.add("b", 4);
        priorityQueue.add("x", 5);
        priorityQueue.add("q", 5);
        priorityQueue.add("a", 8);
        priorityQueue.add("k", 1);
        assertEquals("[null, 1, 5, 2, 5, 5, 8, 4, null, null]", priorityQueue.toString());
    }

    @Test
    public void test2add() {
        priorityQueue.add("t", 10);
        priorityQueue.add("m", 15);
        priorityQueue.add("b", 30);
        priorityQueue.add("x", 60);
        priorityQueue.add("q", 50);
        priorityQueue.add("a", 100);
        priorityQueue.add("k", 140);
        priorityQueue.remove();
        assertEquals("[null, 15, 50, 30, 60, 140, 100, null, null, null]", priorityQueue.toString());
    }
}