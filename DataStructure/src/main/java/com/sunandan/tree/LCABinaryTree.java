package com.sunandan.tree;//Lowest Common Ancestor Binary tree
import java.util.*;

class LCABinaryTree<T>{


    public static void main(String[] args) {
        LCABinaryTree<Integer> lca= new LCABinaryTree<>();
        int[] arr = {1,2,3,4,5,6,7};
        GenericNode<Integer> rootTreeNode=lca.createBinaryTreeWithSortedArray(arr,0,arr.length-1);
        Integer lcaValue = lca.findLCA(rootTreeNode,7,1);
        if(lcaValue != null)
            System.out.println("Lowest Common Factor is : "+lcaValue);
        else
            System.out.println("No Common Ancestor found.\nThe value given may not be present.");
    }

    private T findLCA(GenericNode<T> rootTreeNode, Object value1, Object value2){
        int index=0;
        List<T> commonNodesList = new ArrayList<>();
        List<T> path1List = getPath(rootTreeNode,value1);
        List<T> path2List = getPath(rootTreeNode,value2);
        while(path1List.size()>index && path2List.size()>index){
            if(path1List.get(index).equals(path2List.get(index))){
                commonNodesList.add(path1List.get(index));
            }
            index++;
        }
        if(commonNodesList.size() > 0 )
            return  commonNodesList.get(commonNodesList.size()-1) ;
        return null;
    }

    private   List<T> getPath(GenericNode<T> root, Object value){
        List<T> path = new ArrayList<>();
        path.add(root.data);
        if(root.data.equals(value)){
            return Collections.singletonList(root.data);
        }
        if(root.left!=null){
            path.addAll(getPath(root.left, value));
            if(path.get(path.size()-1)==value)
                return path;
        }
        if(root.right!=null){
            path.addAll(getPath(root.right, value));
            if(path.get(path.size()-1)==value)
                return path;
        }
        return Collections.emptyList();
    }

    private GenericNode<Integer> createBinaryTreeWithSortedArray(int[] arr,int first_pos,int last_pos){
        if(first_pos>last_pos)
                return null;
        int mid = (first_pos + last_pos)/2;
        GenericNode<Integer> node = new GenericNode<Integer>(arr[mid]);
        node.left = createBinaryTreeWithSortedArray(arr, first_pos, mid-1);
        node.right = createBinaryTreeWithSortedArray(arr, mid+1, last_pos);
        return node;
    }
}

