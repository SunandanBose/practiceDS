package com.sunandan.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(Node root1, Node root2) {
        List<Integer> tree1List = getListFromTreeNode(root1);
        List<Integer> tree2List = getListFromTreeNode(root2);
        List<Integer> sortedList = Stream.of(tree1List, tree2List)
                .flatMap(List::stream).collect(Collectors.toList());
        Collections.sort(sortedList);
        return sortedList;

    }

    private List<Integer> getListFromTreeNode(Node root){
        List<Integer> list = new ArrayList();
        if(root == null)
            return list;
        list.add(root.data);
        list.addAll(getListFromTreeNode(root.left));
        list.addAll(getListFromTreeNode(root.right));
        return list;
    }

    public Node createBinaryTreeWithSortedArray(int[] arr){
        return createBinaryTreeWithSortedArray(arr, 0, arr.length-1);
    }

    private Node createBinaryTreeWithSortedArray(int[] arr,int first_pos,int last_pos){
        if(first_pos>last_pos)
            return null;
        int mid = (first_pos + last_pos)/2;
        Node node = new Node(arr[mid]);
        node.left = createBinaryTreeWithSortedArray(arr, first_pos, mid-1);
        node.right = createBinaryTreeWithSortedArray(arr, mid+1, last_pos);
        return node;
    }
    
}
