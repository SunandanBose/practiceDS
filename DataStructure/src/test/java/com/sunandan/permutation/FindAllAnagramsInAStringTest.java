package com.sunandan.permutation;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindAllAnagramsInAStringTest {

    private FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();

    @Test
    public void testFindAnagrams() {
        String s = "cbaebabacd";
        String p = "abc";
        assertEquals(Arrays.asList(0, 6), findAllAnagramsInAString.findAnagrams(s, p));
    }
}