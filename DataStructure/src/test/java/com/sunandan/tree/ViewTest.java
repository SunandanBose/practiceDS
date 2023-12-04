package com.sunandan.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ViewTest {

    View v = new View();

    @Test
    public void test1getRightView() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        List<Integer> result = v.getRightView(root);
        assertEquals(Arrays.asList(1,3,4,6),result);
    }
}