package com.sunandan.GroupProblem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class IslandProblemTest {

    private IslandProblem ip;
    @Before
    public void setUp() throws Exception {
         ip = new IslandProblem();
    }

    @Test
    public void shouldReturn4ForGivenInput() {
        int[][] grid = {{1,0,1,1,1},{0,0,0,1,0},{0,1,1,0,0},{0,1,1,0,1}};
        int count = ip.countClusters(grid);
        assertEquals(4, count);
    }

    @Test
    public void shouldReturn0ForBlankArrayInput() {
        int[][] grid = new int[10][10];
        int count = ip.countClusters(grid);
        assertEquals(0, count);
    }

    @After
    public void tearDown(){

    }
}