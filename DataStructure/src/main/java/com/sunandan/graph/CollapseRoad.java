package com.sunandan.graph;

import com.raj.graph.Graph;

import java.util.*;

public class CollapseRoad {

    Set<Integer> cities = new HashSet<>();

    public static void main(String[] args) {
        int numOfCities = 3;
        int nuOfRoads = 2;
        int[][] path = {{1,2},{2,3}};
        //int[][] path = {{1, 4}, {1, 5}, {2, 3}, {2, 6}, {3, 4}, {4, 7}};
        // 1-4 | 1-5 | 2-3 | 2-6 | 3-4 | 4-7
        int[] ans = solution(numOfCities, nuOfRoads, path);
        System.out.println(Arrays.toString(ans));


    }

    public static int[] solution(int numOfCities, int nuOfRoads, int[][] path) {
        int[] ans = new int[nuOfRoads];
        Graph<Integer> roadGraph = createGraph(nuOfRoads, path);
        System.out.println(roadGraph.toString());
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
        for (int fromCity = 1; fromCity <= numOfCities; fromCity++) {
            for (int toCity = fromCity + 1; toCity <= numOfCities; toCity++) {
                if (!roadGraph.pathExists(fromCity, toCity)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static Graph<Integer> createGraph(int nuOfRoads, int[][] path) {
        Graph<Integer> graph = new Graph<>();
        List<Integer> list = new ArrayList();
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


// [1, 2, 3, 4]
//
//A -> D, E  B -> C, F  C -> B, D  D -> A, G, C E -> A F -> B G -> D
//1,4| 1 -5
/*
    Adj Matrix
        1   2   3   4
     1  0   1   1   0
     2  1   0   0   1
     3  0   0   0   0
     4  0   1   0   0

     Route
        1   2   3   4
     1  1   1   1   0
     2  0   1   0   0
     3  0   0   1   0
     4  0   0   0   1


     Route
        1   2   3   4
     1  1   1   1   1
     2  0   1   0   0
     3  0   0   1   0
     4  0   0   0   1
//create  adj matrix
// getRoutematrix(int,int)
//remove element
3,2
3,1
findpath(from , to){
    if(a[from][to] == 0){
        for(loop on "to" column){
            if(a[][] ==1){
                findpath(from,row);
            }
        }
    }
}

1-3
1-4
2-3
2-4
 */
////    4   2  13 12 34                                    1 -> 3, 2
//2 -> 1, 4
//                                                         3 -> 1
//                                                       4 -> 2
////    4   6    24 34 -> 0 0 0  3