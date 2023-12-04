package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncreasingTripletSubsequenceTest {

    private IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();

    @Test
    public void testIncreasingTriplet() {
        int[] input = {1,0,2,0,-1,3};
        assertEquals(true, increasingTripletSubsequence.increasingTriplet(input));
    }

    @Test
    public void test2IncreasingTriplet() {
        int[] input = {5,4,3,2,1};
        assertEquals(false, increasingTripletSubsequence.increasingTriplet(input));
    }
}