package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {

    private MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    @Test
    public void test1FindMedianSortedArrays() {
        int[] input1 = {1,2};
        int[] input2 = {3,4};
        double expected = 2.5000;
        assertEquals(expected, medianOfTwoSortedArrays.findMedianSortedArrays(input1, input2),1);
    }

    @Test
    public void test2FindMedianSortedArrays() {
        int[] input1 = {1,2};
        int[] input2 = {3,4,15};
        double expected = 3.0000;
        assertEquals(expected, medianOfTwoSortedArrays.findMedianSortedArrays(input1, input2),1);
    }
}