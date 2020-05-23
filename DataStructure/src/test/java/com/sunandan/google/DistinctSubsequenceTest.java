package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctSubsequenceTest {

    DistinctSubsequence ds = new DistinctSubsequence();

    @Test
    public void test1MethodGetDistinctSubsequences() {
        assertEquals(3,ds.getDistinctSubsequences("rabbbit","rabbit"));
    }

    @Test
    public void test2MethodGetDistinctSubsequences() {
        assertEquals(5,ds.getDistinctSubsequences("babgbag","bag"));
    }

    @Test
    public void test3MethodGetDistinctSubsequences() {
        assertEquals(1,ds.getDistinctSubsequences("bag","bag"));
    }

    @Test
    public void test4MethodGetDistinctSubsequences() {
        assertEquals(0,ds.getDistinctSubsequences("bga","bag"));
    }

    @Test
    public void test5MethodGetDistinctSubsequences() {
        assertEquals(4,ds.getDistinctSubsequences("baggage","age"));
    }

}