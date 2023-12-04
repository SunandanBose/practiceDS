package com.raj.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TopologicalSortTest {

    private TopologicalSort ts = new TopologicalSort();

    @Test
    public void test1Methofdsort() {
        Graph<Integer> graph = new Graph<>();
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);
        graph.add(5);
        graph.connectTwoNodes(1,2);
        graph.connectTwoNodes(1,3);
        graph.connectTwoNodes(2,4);
        graph.connectTwoNodes(3,4);
        graph.connectTwoNodes(4,5);
        graph.connectTwoNodes(2,5);
        List<Integer> expected = Arrays.asList(1, 3, 2, 4, 5);
        assertEquals(expected, ts.sort(graph));
    }

    @Test
    public void test2Methofdsort() {
        Graph<Integer> graph = new Graph<>();
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);
        graph.add(5);
        graph.add(6);
        graph.add(7);
        graph.connectTwoNodes(1,3);
        graph.connectTwoNodes(2,3);
        graph.connectTwoNodes(2,4);
        graph.connectTwoNodes(3,5);
        graph.connectTwoNodes(4,6);
        graph.connectTwoNodes(5,6);
        graph.connectTwoNodes(6,7);
        List<Integer> expected = Arrays.asList(2, 4, 1, 3, 5, 6, 7);
        assertEquals(expected, ts.sort(graph));
    }
}