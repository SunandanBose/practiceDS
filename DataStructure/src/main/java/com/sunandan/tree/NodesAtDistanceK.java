package com.sunandan.tree;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistanceK {

    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(Node root, Node target, int K) {
        calculate(root, target, K);

        return result;
    }
    private int calculate(Node root, Node target, int K){
        if(root == null)
            return -1;
        if(root.data == target.data){
            getNodeAtDistanceKFromSubtree(root, K);
            return 0;
        }
        int dl = calculate(root.left, target, K);
        int dr = calculate(root.right, target, K);
        if(dl > -1){
            calculate(root, root.right, dl, K);
            return 1+dl;
        }
        if(dr > -1){
            calculate(root, root.left, dr, K);
            return 1+dr;
        }
        return -1;
    }

    private void calculate(Node root, Node next, int distance, int K){
        if(distance + 1 == K)
            result.add(root.data);
        else
            getNodeAtDistanceKFromSubtree(next, K-distance-2);
    }

    private void getNodeAtDistanceKFromSubtree(Node root, int K){
        if(root == null)
            return;
        if(K == 0)
            result.add(root.data);
        getNodeAtDistanceKFromSubtree(root.left, K-1);
        getNodeAtDistanceKFromSubtree(root.right, K-1);
    }
    
}
