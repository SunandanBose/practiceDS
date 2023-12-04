package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxRectangleTest {

    private MaxRectangle mr = new MaxRectangle();

    @Test
    public void testGetMaxAreaOfRectangle() {
        int[][] inputMatrix = {{1,1,1},{0,1,1},{1,0,0}};
        assertEquals(4,mr.getMaxAreaOfRectangle(inputMatrix));
    }

    @Test
    public void test2GetMaxAreaOfRectangle() {
        int[][] inputMatrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        assertEquals(6,mr.getMaxAreaOfRectangle(inputMatrix));
    }
}