package com.sunandan.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetTest {

    private Subset subset = new Subset();

    @Test
    public void testSubsets() {
        int[] input = {1,2,3};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(),Arrays.asList(1),Arrays.asList(2),Arrays.asList(1,2),Arrays.asList(3),Arrays.asList(1,3),Arrays.asList(2,3), Arrays.asList(1,2,3));
        assertEquals(expected, subset.subsets(input));
    }

    @Test
    public void testStringSubsets() {
        String input = "abc";
        List<String> expected = Arrays.asList("","a","b","ab","c","ac","bc","abc");
        assertEquals(expected, subset.StringSubsets(input));
    }
}