package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    public void testLongestCommonPrefix() {
        String[] array = {"flower", "flow", "flight"};
        assertEquals("fl", longestCommonPrefix.longestCommonPrefix(array));
    }
}