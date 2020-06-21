package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalTest {

    private MergeInterval mi = new MergeInterval();

    @Test
    public void test1merge() {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};
        assertArrayEquals(expected,mi.merge(input));
    }

    @Test
    public void test2merge() {
        int[][] input = {{1,4},{4,5}};
        int[][] expected = {{1,5}};
        assertArrayEquals(expected,mi.merge(input));
    }
}