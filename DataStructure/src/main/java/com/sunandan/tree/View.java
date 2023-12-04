package com.sunandan.tree;

import java.util.ArrayList;
import java.util.List;

public class View {

    private List<Integer> rightViewNodes = new ArrayList<>();

    public List<Integer> getRightView(Node root){
        getRightView(root, 0);
        return rightViewNodes;
    }


    private void getRightView(Node node, int verticalDistanceFromRoot){
        if(node == null){
            return;
        }
        if(verticalDistanceFromRoot == rightViewNodes.size())
            rightViewNodes.add(node.data);
        getRightView(node.right, verticalDistanceFromRoot + 1);
        getRightView(node.left, verticalDistanceFromRoot + 1);
    }

}
