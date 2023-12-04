package com.sunandan.Random;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

    @Test
    public void test1getCount() {
        List<Integer> input = Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60, 80);
        assertEquals(6, lis.getCount(input));
    }

    @Test
    public void testgetLIS() {
        //List<Integer> input = Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60, 80);
        int[] input = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        assertEquals(6, lis.lengthOfLIS(input));
    }
}