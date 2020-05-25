package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinJumpArrayTest {

    private MinJumpArray mja = new MinJumpArray();

    @Test
    public void test1MethodGetMinJump() {
        int[] inputArray = {2, 3, 1, 1, 4};
        assertEquals(2, mja.getMinJump(inputArray));
    }

    @Test
    public void test2MethodGetMinJump() {
        int[] inputArray = {0};
        assertEquals(0, mja.getMinJump(inputArray));
    }

    @Test
    public void test3MethodGetMinJump() {
        int[] inputArray = {1,2};
        assertEquals(1, mja.getMinJump(inputArray));
    }
}