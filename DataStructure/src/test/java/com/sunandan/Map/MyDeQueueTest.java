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
    public void testIsEmpty() {
        assertEquals(true, myDeQueue.isEmpty());
    }

    @Test
    public void testAdd() {
        myDeQueue.add(2);
        myDeQueue.add(3);
        String expected = "[2, 3]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void testAddFirst() {
        myDeQueue.addFirst(2);
        myDeQueue.addFirst(3);
        String expected = "[3, 2]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void testAddLast() {
        myDeQueue.addLast(2);
        myDeQueue.addLast(4);
        String expected = "[2, 4]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void testRemoveFirst() {
        myDeQueue.addLast(2);
        myDeQueue.addLast(4);
        myDeQueue.removeFirst();
        String expected = "[4]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void testRemoveLast() {
        myDeQueue.addLast(2);
        myDeQueue.addLast(4);
        myDeQueue.removeLast();
        String expected = "[2]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void testRemove() {
        myDeQueue.addLast(5);
        myDeQueue.addLast(4);
        myDeQueue.remove();
        String expected = "[4]";
        assertEquals(expected, myDeQueue.toString());
    }

    @Test
    public void testSize(){
        myDeQueue.addLast(5);
        myDeQueue.addLast(4);
        assertEquals(2, myDeQueue.size());
    }

    @Test
    public void testPeekFirst(){
        myDeQueue.addLast(5);
        myDeQueue.addLast(4);
        int expected = 5;
        int actual = myDeQueue.peekFirst();
        assertEquals(expected, actual);
    }

    @Test
    public void testPeekLast(){
        myDeQueue.addLast(5);
        myDeQueue.addLast(4);
        int expected = 4;
        int actual = myDeQueue.peekLast();
        assertEquals(expected, actual);
    }
}