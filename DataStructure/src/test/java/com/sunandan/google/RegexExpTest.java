package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegexExpTest {

    private RegexExp re = new RegexExp();

    @Test
    public void test1MethodisMatch() {
        assertEquals(true,re.isMatch("aab","a*b"));
    }

    @Test
    public void test2MethodisMatch() {
        assertEquals(true,re.isMatch("aab","c*a*b"));
    }

    @Test
    public void test3MethodisMatch() {
        assertEquals(false,re.isMatch("mississippi","mis*is*p*."));
    }

    @Test
    public void test4MethodisMatch() {
        assertEquals(true,re.isMatch("da",".*"));
    }
}