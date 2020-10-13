package com.sunandan.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDeQueueTest {

    private MyDeQueue<Integer> myDeQueue;

    @Before
    public void setUp() throws Exception {
        myDeQueue = new MyDeQueue<>();
    }

    @Test
    public void isEmpty() {
        assertEquals(true, myDeQueue.isEmpty());
    }

    @Test
    public void add() {
        myDeQueue.add(2);
        myDeQueue.add(3);
        String expected = "[2, 3]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void addFirst() {
        myDeQueue.addFirst(2);
        myDeQueue.addFirst(3);
        String expected = "[3, 2]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void addLast() {
        myDeQueue.addLast(2);
        myDeQueue.addLast(4);
        String expected = "[2, 4]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void removeFirst() {
        myDeQueue.addLast(2);
        myDeQueue.addLast(4);
        myDeQueue.removeFirst();
        String expected = "[4]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void removeLast() {
        myDeQueue.addLast(2);
        myDeQueue.addLast(4);
        myDeQueue.removeLast();
        String expected = "[2]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void remove() {
        myDeQueue.addLast(5);
        myDeQueue.addLast(4);
        myDeQueue.removeLast();
        String expected = "[5]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void size(){
        myDeQueue.addLast(5);
        myDeQueue.addLast(4);
        assertEquals(2, myDeQueue.size());
    }
}