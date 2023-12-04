package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {

    private SingleNumber singleNumber = new SingleNumber();

    @Test
    public void testSingleNumber() {
        int[] input = {4,1,2,1,2};
        int expected = 4;
        assertEquals(expected, singleNumber.singleNumber(input));
    }
}