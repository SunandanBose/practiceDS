package com.sunandan.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfRootToLeafBinaryNumbersTest {

    private SumOfRootToLeafBinaryNumbers sumOfRootToLeafBinaryNumbers = new SumOfRootToLeafBinaryNumbers();
    private AllElementsInTwoBinarySearchTrees allElementsInTwoBinarySearchTrees = new AllElementsInTwoBinarySearchTrees();
    @Test
    public void test1SumRootToLeaf() {
        Node root = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(new int[]{0,0,1,1,0,1,1});
        assertEquals(22,sumOfRootToLeafBinaryNumbers.sumRootToLeaf(root));
    }

    @Test
    public void test2SumRootToLeaf() {
        Node root = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(new int[]{0});
        assertEquals(0,sumOfRootToLeafBinaryNumbers.sumRootToLeaf(root));
    }

    @Test
    public void test3SumRootToLeaf() {
        Node root = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(new int[]{1});
        assertEquals(1,sumOfRootToLeafBinaryNumbers.sumRootToLeaf(root));
    }

    @Test
    public void test4SumRootToLeaf() {
        Node root = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(new int[]{1,1});
        assertEquals(3,sumOfRootToLeafBinaryNumbers.sumRootToLeaf(root));
    }
}