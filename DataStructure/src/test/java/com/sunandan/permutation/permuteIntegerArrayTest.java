package com.sunandan.permutation;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class permuteIntegerArrayTest {

    private PermuteIntegerArray permuteIntegerArray = new PermuteIntegerArray();

    @Test
    public void permute() {
        int[] input = {1,2,3};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3, 2, 1), Arrays.asList(2, 3, 1), Arrays.asList(2, 1, 3), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 2), Arrays.asList(1, 2, 3));
        assertEquals(expected,permuteIntegerArray.permute(input));
    }
}