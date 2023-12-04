package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistributeCandiesToPeopleTest {

    private DistributeCandiesToPeople dctp = new DistributeCandiesToPeople();

    @Test
    public void test1MethodDistributeCandies() {
        int[] expectedOutput = {1,2,3,1};
        assertArrayEquals(expectedOutput,dctp.distributeCandies(7,4));
    }

    @Test
    public void test2MethodDistributeCandies() {
        int[] expectedOutput = {5,2,3};
        assertArrayEquals(expectedOutput,dctp.distributeCandies(10,3));
    }
}