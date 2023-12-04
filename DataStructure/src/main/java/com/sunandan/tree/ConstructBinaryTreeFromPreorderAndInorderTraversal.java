package com.sunandan.tree;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public Node buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    private Node buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        Node root = new Node(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.data) {
                inIndex = i;
            }
        }
        root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    
}
