package com.sunandan.leetcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReOrderListTest {

    private ReOrderList rol = new ReOrderList();


    @Test
    public void test1MethodReorderList() {
        List<Integer> inputList = new ArrayList<>();
        inputList = Arrays.asList(1, 2, 3, 4);
        LinkedNode head = LinkedNode.insert(inputList);
        String expected = "1423";
        rol.reorderList(head);
        assertEquals(expected, LinkedNode.getLinkedListAsString(head));
    }

    @Test
    public void test2MethodReorderList() {
        List<Integer> inputList = new ArrayList<>();
        inputList = Arrays.asList(1, 2, 3, 4, 5);
        LinkedNode head = LinkedNode.insert(inputList);
        String expected = "15243";
        rol.reorderList(head);
        assertEquals(expected, LinkedNode.getLinkedListAsString(head));
    }


}