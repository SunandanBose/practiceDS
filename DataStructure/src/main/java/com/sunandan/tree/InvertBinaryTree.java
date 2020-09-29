package com.sunandan.tree;

import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {

    public Node invertTree(Node root){
        if(root == null) return root;
        Node right = invertTree(root.right);
        Node left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }



    public Integer[] binaryTreeToArray(Node root){
        List<Integer> result = binaryTreeToList(root);
        return result.toArray(new Integer[]{});
    }

    private List<Integer> binaryTreeToList(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null)
            result.addAll(binaryTreeToList(root.left));
        if (root.right != null)
            result.addAll(binaryTreeToList(root.right));
        result.add(root.data);
        return result;
    }
}
