package com.sunandan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PopulatingNextRightPointersInEachNode {

    public NextTreeNode connect(NextTreeNode root) {
        Map<Integer, List<NextTreeNode>> levelOrderMap = new TreeMap<>();
        getLevelOrder(root, 0, levelOrderMap);
        for(Integer level : levelOrderMap.keySet()){
            if(levelOrderMap.get(level).size() > 1){
                List<NextTreeNode> nodes = levelOrderMap.get(level);
                NextTreeNode prev = nodes.get(0);
                for(int i = 1; i < nodes.size() ; i++){
                    prev.next = nodes.get(i);
                    prev = nodes.get(i);
                }
            }
        }
        return root;
    }
    private void getLevelOrder(NextTreeNode root, int levelOrder, Map<Integer, List<NextTreeNode>> levelOrderMap){
        if(root == null)
            return;
        if(levelOrderMap.get(levelOrder) == null)
            levelOrderMap.put(levelOrder, new ArrayList<NextTreeNode>());
        List<NextTreeNode> existingNodes = levelOrderMap.get(levelOrder);
        existingNodes.add(root);
        levelOrderMap.put(levelOrder, existingNodes);
        getLevelOrder(root.left, levelOrder+1, levelOrderMap);
        getLevelOrder(root.right, levelOrder+1, levelOrderMap);
    }
}
