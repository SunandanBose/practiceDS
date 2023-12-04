package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterLeaveStringTest {

    private InterLeaveString ils = new InterLeaveString();

    @Test
    public void test1MethodinterLeaveString() {
        assertEquals(true,ils.interLeaveString("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void test2MethodinterLeaveString() {
        assertEquals(false,ils.interLeaveString("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void test3MethodinterLeaveString() {
        assertEquals(true,ils.interLeaveString("aa", "ab", "aaba"));
    }
}