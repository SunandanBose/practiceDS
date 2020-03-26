package com.raj.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    }
    @Test
    public void testHasPathShouldReturnTrueForPathFromAtoBandD() {
        // A -> , E  
        // B -> C, F 
        // C -> B, D  
        // D -> , G, C 
        // E -> A 
        // F -> B 
        // G -> D

        assertTrue(graph.pathExists("A","D"));
        assertTrue(graph.pathExists("A","B"));
        //assertTrue(graph.pathExists("A","C"));
        //assertTrue(graph.pathExists("A","D"));
        //assertTrue(graph.pathExists("A","E"));
        //assertTrue(graph.pathExists("A","F"));
        //assertTrue(graph.pathExists("A","G"));
    }

    @Test
    public void testDisconnectPathShouldRemoveConnectionBetweenAandD(){
        graph.disconnectTwoNodes("A", "D");
        assertFalse(graph.pathExists("A", "D"));
        assertTrue(graph.pathExists("D", "A"));
        assertTrue(graph.pathExists("D", "G"));
        assertTrue(graph.pathExists("D", "C"));
    }

    @Test
    public void testEdgeExistsInElement(){
        assertTrue(graph.edgeExists("A", "D"));
        assertFalse(graph.edgeExists("A", "B"));
    }
}