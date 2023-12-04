package com.sunandan.tree;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AllElementsInTwoBinarySearchTreesTest {

    private AllElementsInTwoBinarySearchTrees allElementsInTwoBinarySearchTrees = new AllElementsInTwoBinarySearchTrees();

    @Test
    public void test1GetAllElements() {
        Node root1 = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(new int[]{1, 2, 3, 4, 5});
        Node root2 = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(new int[]{5, 6, 7, 8, 9});
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9), allElementsInTwoBinarySearchTrees.getAllElements(root1, root2));
    }
}