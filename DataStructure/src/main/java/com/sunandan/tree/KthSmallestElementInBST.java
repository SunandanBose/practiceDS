package com.sunandan.tree;

import java.util.ArrayList;

public class KthSmallestElementInBST {

    public int kthSmallest(Node root, int k) {
        ArrayList<Integer> inOrderList = inOrder(root, new ArrayList<Integer>());
        return inOrderList.get(k-1);
    }

    private ArrayList<Integer> inOrder(Node root, ArrayList<Integer> list){
        if(root == null) return null;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
        return list;
    }

}
