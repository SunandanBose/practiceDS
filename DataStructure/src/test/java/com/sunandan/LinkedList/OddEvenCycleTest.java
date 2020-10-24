package com.sunandan.LinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OddEvenCycleTest {

    private LList lList = new LList();
    private OddEvenCycle oddEvenCycle = new OddEvenCycle();

    @Test
    public void test1OddEvenList() {
        Node head = LList.insert(Arrays.asList(1,2,3,4,5));
        List<Integer> actual = LList.getList(oddEvenCycle.oddEvenList(head));
        List<Integer> expected = Arrays.asList(1,3,5,2,4);
        assertEquals(expected, actual);
    }

    @Test
    public void test2OddEvenList() {
        Node head = LList.insert(Arrays.asList(2,1,3,5,6,4,7));
        List<Integer> actual = LList.getList(oddEvenCycle.oddEvenList(head));
        List<Integer> expected = Arrays.asList(2,3,6,7,1,5,4);
        assertEquals(expected, actual);
    }
}