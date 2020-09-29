package com.sunandan.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InvertBinaryTreeTest {

    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
    AllElementsInTwoBinarySearchTrees allElementsInTwoBinarySearchTrees = new AllElementsInTwoBinarySearchTrees();

    @Test
    public void test1invertTree() {
        int[] input = {4,2,7,1,3,6,9};
        Integer[] expected = {9,3,6,7,4,2,1};
        Node root = allElementsInTwoBinarySearchTrees.createBinaryTreeWithSortedArray(input);
        assertArrayEquals(expected,invertBinaryTree.binaryTreeToArray(invertBinaryTree.invertTree(root)));
    }
}