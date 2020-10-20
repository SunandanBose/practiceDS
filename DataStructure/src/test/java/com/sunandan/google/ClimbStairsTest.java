package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbStairsTest {

    private ClimbStairs climbStairs = new ClimbStairs();

    @Test
    public void climbStairs() {
        assertEquals(3, climbStairs.climbStairs(3));
    }
}