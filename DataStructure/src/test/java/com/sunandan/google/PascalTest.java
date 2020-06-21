package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class PascalTest {

    private Pascal p = new Pascal();

    @Test
    public void test1MethodGetKthRowInPascal() {
        int[] expected = {1, 3, 3, 1};
        assertArrayEquals(expected,p.getKthRowInPascal(3));
    }

    @Test
    public void test2MethodGetKthRowInPascal() {
        int[] expected = {1,5,10,10,5,1};
        assertArrayEquals(expected,p.getKthRowInPascal(5));
    }
}