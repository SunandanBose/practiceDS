package com.sunandan.graph;

import com.raj.graph.Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class ShortestReach {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        Graph<Integer> g = new Graph<Integer>();
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        int count=0;
        for(int i=1;i<=n;i++) g.add(i-1);
        for(int i=0;i<m;i++){
            g.connectTwoNodes(edges[i][0]-1,edges[i][1]-1);
            g.connectTwoNodes(edges[i][1]-1,edges[i][0]-1);
        }
        LinkedList<Integer> queue = new LinkedList();
        queue.add(s-1);
        ans[s-1]=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer neighbour : g.getEdgeList(node)){
                if(ans[neighbour] == -1){
                    ans[neighbour] = ans[node] + 6;
                    queue.add(neighbour);
                }
            }
        }
        return Arrays.stream(ans).filter(x -> x!=0).toArray() ;
    }

}
