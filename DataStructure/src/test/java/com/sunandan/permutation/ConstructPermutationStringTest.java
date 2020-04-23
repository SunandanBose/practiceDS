package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructPermutationStringTest {

    private ConstructPermutationString cps = new ConstructPermutationString();
    @Test
    public void methodCanConstructShouldReturnTrue() {
        assertTrue(cps.canConstruct("annabelle",2));
        assertTrue(cps.canConstruct("true",4));
        assertTrue(cps.canConstruct("yzyzyzyzyzyzyzy",2));
        assertTrue(cps.canConstruct("aabbccdde",3));
        assertTrue(cps.canConstruct("abcdd",4));
        assertTrue(cps.canConstruct("abcdd",3));
        assertTrue(cps.canConstruct("aaa",2));
        assertTrue(cps.canConstruct("qlkzenwmmnpkopu",15));
        assertTrue(cps.canConstruct("ibzkwaxxaggkiwjbeysz",15));
        assertTrue(cps.canConstruct("jsautfnlcmwqpzycehdulmdencthhlzsnijd",35));
    }


    @Test
    public void methodCanConstructShouldReturnFalse() {
        assertFalse(cps.canConstruct("leetcode",3));
        assertFalse(cps.canConstruct("cr",7));
    }
}