package com.sunandan.LinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DeleteDuplicatesTest {

    private DeleteDuplicates deleteDuplicates = new DeleteDuplicates();

    @Test
    public void testDeleteDuplicates() {
        Node head = new Node(1);
        Node node = new Node(1);
        head.next = node;
        Node node1 = new Node(2);
        node.next = node1;
        node1.next = null;
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, deleteDuplicates.getList(deleteDuplicates.deleteDuplicates(head)));
    }
}