package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {

    private MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

    @Test
    public void test1MinWindow() {
        String Sinput = "ADOBECODEBANC";
        String Tinput = "ABC";
        assertEquals("BANC", minimumWindowSubstring.minWindow(Sinput,Tinput));
    }

    @Test
    public void test2MinWindow() {
        String Sinput = "ABAACBAB";
        String Tinput = "ABC";
        assertEquals("ACB", minimumWindowSubstring.minWindow(Sinput,Tinput));
    }
}