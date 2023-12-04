package com.raj.graph;

import java.util.*;

public class TopologicalSort {


    Set<Integer> visitedNodes = new HashSet<>();

    public List<Integer> sort(Graph<Integer> graph){
        final List<Integer> nodes = graph.getNodes();
        int totalNodes = nodes.size();
        Stack<Integer> sortedStack  = new Stack<>();
        int index = -1;
        while(totalNodes > sortedStack.size()) {
            index++;
            if(visitedNodes.contains(nodes.get(index)))
                continue;
            sortedStack.addAll(sort(graph.getNode(nodes.get(index)).get()));
        }
        List<Integer> result = new ArrayList<>(sortedStack);
        Collections.reverse(result);
        return result;
    }

    private Stack<Integer> sort(Node<Integer> node){
        Stack<Integer> sortedStack = new Stack<>();
        if(visitedNodes.contains(node.data))    return sortedStack;
        visitedNodes.add(node.data);
        if(node.children.size() == 0) {
            sortedStack.add(node.data);
            return sortedStack;
        }
        for(Node<Integer> n: node.children){
            sortedStack.addAll(sort(n));
        }
        if(!sortedStack.contains(node.data))
            sortedStack.add(node.data);
        return sortedStack;
    }

}
