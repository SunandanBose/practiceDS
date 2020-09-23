package com.sunandan.tree;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class SumOfRootToLeafBinaryNumbers {

    private LinkedList<Integer> list = new LinkedList<>();
    private int sum = 0;

    public int sumRootToLeaf(Node root) {
        traverse(root);
        return sum;
    }

    private void traverse(Node root) {
        if(root != null){
            list.add(root.data);;
            if(root.left == null && root.right == null)
                getElementFromList(list);
            traverse(root.left);
            traverse(root.right);
            list.pollLast();
        }
    }

    private void getElementFromList(LinkedList<Integer> list) {
        String binary = list.stream().map(x -> x.toString()).collect(Collectors.joining());
        sum += Integer.parseInt(binary,2);
    }
}
