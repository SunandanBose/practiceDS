package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {

    private HouseRobber houseRobber = new HouseRobber();

    @Test
    public void testRob() {
        int[] input = {2, 7, 9, 3, 1};
        assertEquals(12, houseRobber.rob(input));
    }
}