package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMinimumInRotatedSortedArrayIITest {

    private FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();

    @Test
    public void test1FindMin() {
        int[] input = {3,1};
        assertEquals(1,findMinimumInRotatedSortedArrayII.findMin(input));
    }

    @Test
    public void test2FindMin() {
        int[] input = {1,3,5};
        assertEquals(1,findMinimumInRotatedSortedArrayII.findMin(input));
    }

    @Test
    public void test3FindMin() {
        int[] input = {2,2,2,0,1};
        assertEquals(0,findMinimumInRotatedSortedArrayII.findMin(input));
    }

    @Test
    public void test4FindMin() {
        int[] input = {4,5,6,7,0,1,2};
        assertEquals(0,findMinimumInRotatedSortedArrayII.findMin(input));
    }

    @Test
    public void test5FindMin() {
        int[] input = {0,1,2,4,5,6,7};
        assertEquals(0,findMinimumInRotatedSortedArrayII.findMin(input));
    }


}