package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

    @Test
    public void getLongestCommonSubsequenceCount() {
        assertEquals(3, longestCommonSubsequence.getLongestCommonSubsequenceCount("ace","xabccde"));
    }

    @Test
    public void getLongestCommonSubsequenceString() {
        assertEquals("ace", longestCommonSubsequence.getLongestCommonSubsequenceString("ace","xabccde"));
    }
}