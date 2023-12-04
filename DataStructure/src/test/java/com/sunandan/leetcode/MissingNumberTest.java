package com.sunandan.leetcode;


import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    private MissingNumber missingNumber = new MissingNumber();

    @Test
    public void testMissingNumber() {
        int[] input = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, missingNumber.missingNumber(input));
    }
}