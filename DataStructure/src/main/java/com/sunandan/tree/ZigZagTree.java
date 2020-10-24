package com.sunandan.tree;

import java.util.*;

public class ZigZagTree {

    Map<Integer, List<Integer>> verticalLevelMap = new TreeMap<>();

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(root, 0);
        int count = 1;
        for(Integer level : verticalLevelMap.keySet()){
            if(count++ % 2 == 0)
                Collections.reverse(verticalLevelMap.get(level));
            result.add(verticalLevelMap.get(level));
        }
        return result;
    }

    private void zigzagLevelOrder(Node root, int verticalLevel){
        if(root == null)
            return;
        if(verticalLevelMap.get(verticalLevel) == null){
            verticalLevelMap.put(verticalLevel, new ArrayList<>());
        }
        List<Integer> existingList = verticalLevelMap.get(verticalLevel);
        existingList.add(root.data);
        verticalLevelMap.put(verticalLevel, existingList);
        zigzagLevelOrder(root.left, verticalLevel+1);
        zigzagLevelOrder(root.right, verticalLevel+1);
    }
}
