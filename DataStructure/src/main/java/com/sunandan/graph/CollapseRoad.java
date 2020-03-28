package com.sunandan.graph;

import com.raj.graph.Graph;

import java.util.*;

public class CollapseRoad {

    public static int[] solution(int numOfCities, int nuOfRoads, int[][] path) {
        int[] ans = new int[nuOfRoads];
        Graph<Integer> roadGraph = createGraph(nuOfRoads, path);
        System.out.println(roadGraph);
        for (int i = 0; i < nuOfRoads; i++) {
            roadGraph = collapseRoad(path, i, roadGraph);
            ans[i] = countUnreachableCities(numOfCities, roadGraph);
        }
        return ans;
    }

    private static Graph<Integer> collapseRoad(int[][] path, int index, Graph<Integer> roadGraph) {
        roadGraph.disconnectTwoNodes(path[index][0], path[index][1]);
        roadGraph.disconnectTwoNodes(path[index][1], path[index][0]);
        return roadGraph;
    }

    private static int countUnreachableCities(int numOfCities, Graph<Integer> roadGraph) {
        int count = 0;
        List<Integer> getAllCities = roadGraph.getNodes();
        for (int i = 0; i < numOfCities; i++) {
            for (int j = i + 1; j < numOfCities; j++) {
                if (!roadGraph.pathExists(getAllCities.get(i), getAllCities.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static Graph<Integer> createGraph(int nuOfRoads, int[][] path) {
        Graph<Integer> graph = new Graph<>();
        for (int i = 0; i < nuOfRoads; i++) {
            graph.add(path[i][0]);
            graph.add(path[i][1]);
            if (!graph.edgeExists(path[i][0], path[i][1])) {
                graph.connectTwoNodes(path[i][0], path[i][1]);
                graph.connectTwoNodes(path[i][1], path[i][0]);
            }
        }
        return graph;
    }


}

