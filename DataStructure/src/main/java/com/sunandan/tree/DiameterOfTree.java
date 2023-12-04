package com.sunandan.tree;

public class DiameterOfTree {

    private int max ;
    public int diameterOfBinaryTree(Node root) {
        max = 0;
        maxDiameter(root);
        return max;
    }

    private void maxDiameter(Node root){
        if(root == null) return;
        max = Math.max(max, height(root.left) + height(root.right));
        maxDiameter(root.left);
        maxDiameter(root.right);
    }

    private int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
