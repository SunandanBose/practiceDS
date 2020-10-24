package com.sunandan.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    private ConstructBinaryTreeFromPreorderAndInorderTraversal construct = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    @Test
    public void test1BuildTree() {
        int[] inOrder = {2, 1, 3};
        int[] preOrder = {1, 2, 3};
        assertEquals(null, construct.buildTree(preOrder, inOrder));
    }
}