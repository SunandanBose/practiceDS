package com.raj.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MergeSortTest {

    private MergeSort ms = new MergeSort();

    @Test
    public void test1sort() {
        List<Integer> input = new ArrayList(Arrays.asList(2, 1, 4, 3, -2, 56));
        List<Integer> expected = new ArrayList(Arrays.asList(-2, 1, 2, 3, 4, 56));
        //System.out.println(ms.sort(input));
        assertEquals(expected,ms.sort(input));
    }
}