package com.sunandan.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NumbersWithSameConsecutiveDifferencesTest {

    private NumbersWithSameConsecutiveDifferences nwscd = new NumbersWithSameConsecutiveDifferences();

    @Test
    public void test1MethodNumsSameConsecDiff() {
        int[] expectedOutput = {181,292,707,818,929};
        int[] actualOutput = nwscd.numsSameConsecDiff(3, 7);
        Arrays.sort(expectedOutput);
        Arrays.sort(actualOutput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test2MethodNumsSameConsecDiff() {
        int[] expectedOutput = {10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98};
        int[] actualOutput = nwscd.numsSameConsecDiff(2, 1);
        Arrays.sort(expectedOutput);
        Arrays.sort(actualOutput);
        assertArrayEquals(expectedOutput, actualOutput);

    }
}