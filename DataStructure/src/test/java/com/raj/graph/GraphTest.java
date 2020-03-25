package com.raj.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    private Graph<String> graph = new Graph<>();
    @Before
    public void setup(){
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
        graph.add("F");
        graph.add("G");

        graph.connectTwoNodes("A", "D");
        graph.connectTwoNodes("A", "E");
        graph.connectTwoNodes("B", "C");
        graph.connectTwoNodes("B", "F");
        graph.connectTwoNodes("C", "B");
        graph.connectTwoNodes("C", "D");
        graph.connectTwoNodes("D", "A");
        graph.connectTwoNodes("D", "G");
        graph.connectTwoNodes("D", "C");
        graph.connectTwoNodes("E", "A");
        graph.connectTwoNodes("F", "B");
        graph.connectTwoNodes("G", "D");

        System.out.println(graph);

    }
    @Test
    public void testHasPath() {
        assertTrue(graph.pathExists("A","D"));
        assertTrue(graph.pathExists("A","B"));
    }

}