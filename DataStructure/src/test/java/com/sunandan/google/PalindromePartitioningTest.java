package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromePartitioningTest {

    private PalindromePartitioning pp = new PalindromePartitioning();

    @Test
    public void test1MethodPalindromeByMinCut() {
        assertEquals(2, pp.palindromeByMinPartitionCut("BANAN"));
    }

    @Test
    public void test2MethodPalindromeByMinCut() {
        assertEquals(1, pp.palindromeByMinPartitionCut("BANANA"));
    }

    @Test
    public void test3MethodPalindromeByMinCut() {
        assertEquals(0, pp.palindromeByMinPartitionCut("ABA"));
    }

    @Test
    public void test4MethodPalindromeByMinCut() {
        assertEquals(1, pp.palindromeByMinPartitionCut("AAB"));
    }

    @Test
    public void test5MethodPalindromeByMinCut() {
        assertEquals(3, pp.palindromeByMinPartitionCut("BLAAANANA"));
    }
}