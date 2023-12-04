package com.sunandan.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {


    Map<Integer, Boolean> cache = null;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        cache = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = graph.get(prerequisites[i][1]);
            list.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, new boolean[numCourses], i)) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int course) {
        if (cache.get(course) != null)
            return cache.get(course);
        if (visited[course])
            return false;
        visited[course] = true;
        for (Integer i : graph.get(course)) {
            boolean result = dfs(graph, visited, i);
            cache.put(i, result);
            if (!result)
                return false;
        }
        visited[course] = false;
        return true;
    }
}
