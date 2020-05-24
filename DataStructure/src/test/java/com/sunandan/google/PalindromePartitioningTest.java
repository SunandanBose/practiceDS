package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromePartitioningTest {

    private PalindromePartitioning pp = new PalindromePartitioning();

    @Test
    public void test1MethodPalindromeByMinCut() {
        assertEquals(2,pp.palindromeByMinCut("BANAN"));
    }

    @Test
    public void test2MethodPalindromeByMinCut() {
        assertEquals(1,pp.palindromeByMinCut("BANANA"));
    }

    @Test
    public void test3MethodPalindromeByMinCut() {
        assertEquals(0,pp.palindromeByMinCut("ABA"));
    }

    @Test
    public void test4MethodPalindromeByMinCut() {
        assertEquals(1,pp.palindromeByMinCut("AAB"));
    }

    @Test
    public void test5MethodPalindromeByMinCut() {
        assertEquals(3,pp.palindromeByMinCut("BLAAANANA"));
    }
}