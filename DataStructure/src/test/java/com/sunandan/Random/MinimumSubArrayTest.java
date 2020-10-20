package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSubArrayTest {

    private MinimumSubArray minimumSubArray = new MinimumSubArray();

    @Test
    public void test1MinSubArrayLen() {
        int inputSum = 7;
        int[] inputArray = {2,3,1,2,4,3};
        assertEquals(2, minimumSubArray.minSubArrayLen(inputSum, inputArray));
    }

    @Test
    public void test2MinSubArrayLen() {
        int inputSum = 100;
        int[] inputArray = {};
        assertEquals(0, minimumSubArray.minSubArrayLen(inputSum, inputArray));
    }

    @Test
    public void test3MinSubArrayLen() {
        int inputSum = 100;
        int[] inputArray = {101};
        assertEquals(1, minimumSubArray.minSubArrayLen(inputSum, inputArray));
    }

    @Test
    public void test4MinSubArrayLen() {
        int inputSum = 4;
        int[] inputArray = {1,4,4};
        assertEquals(1, minimumSubArray.minSubArrayLen(inputSum, inputArray));
    }
}