package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberIITest {

    private HouseRobberII houseRobberII = new HouseRobberII();

    @Test
    public void testRob() {
        int[] input = {1, 2, 3, 1};
        assertEquals(4, houseRobberII.rob(input));
    }
}