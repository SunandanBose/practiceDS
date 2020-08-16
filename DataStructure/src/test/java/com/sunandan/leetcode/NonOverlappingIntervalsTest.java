package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonOverlappingIntervalsTest {

    private NonOverlappingIntervals noi = new NonOverlappingIntervals();

    @Test
    public void test1eraseOverlapIntervals() {
        int[][] input = {{1,2},{2,3},{3,4},{1,3}};
        assertEquals(1, noi.eraseOverlapIntervals(input));
    }

    @Test
    public void test2eraseOverlapIntervals() {
        int[][] input = {{1,2},{1,2},{1,2}};
        assertEquals(2, noi.eraseOverlapIntervals(input));
    }

    @Test
    public void test3eraseOverlapIntervals() {
        int[][] input = {{1,5},{1,2},{2,3},{1,3}};
        assertEquals(2, noi.eraseOverlapIntervals(input));
    }

    @Test
    public void test4eraseOverlapIntervals() {
        int[][] input = {};
        assertEquals(0, noi.eraseOverlapIntervals(input));
    }

    @Test
    public void test5eraseOverlapIntervals() {
        int[][] input = {{}};
        assertEquals(0, noi.eraseOverlapIntervals(input));
    }

    @Test
    public void test6eraseOverlapIntervals() {
        int[][] input = {{0,1},{3,4},{1,2}};
        assertEquals(0, noi.eraseOverlapIntervals(input));
    }
}