package com.sunandan.graph;

import com.raj.graph.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollapseRoadTest {

    private Graph<Integer> graph = new Graph<>();
    private CollapseRoad cr = new CollapseRoad();

    @Test
    public void testSolutionMethodShouldGiveMeNumberOfRoadsCollapsed(){
        int numOfCities = 3;
        int nuOfRoads = 2;
        int[][] path = {{1,2},{2,3}};
        int[] expectedValue = {2,3};
        int[] actualValue= CollapseRoad.solution(numOfCities, nuOfRoads, path);
        assertArrayEquals(actualValue,expectedValue);
    }


}