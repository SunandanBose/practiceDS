package com.sunandan.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortArrayByParityTest {

    SortArrayByParity sabp = new SortArrayByParity();

    @Test
    public void sortArrayByParity() {
        int[] input = {3, 1, 2, 4};
        int[] output = sabp.sortArrayByParity(input);
        boolean isOutputCorrect = false;
        if (Arrays.equals(output, new int[]{2, 4, 3, 1}) || Arrays.equals(output, new int[]{4, 2, 3, 1})
                || Arrays.equals(output, new int[]{2, 4, 1, 3}) || Arrays.equals(output, new int[]{4, 2, 1, 3})) {
            isOutputCorrect = true;
        }
        assertEquals(true, isOutputCorrect);
    }
}