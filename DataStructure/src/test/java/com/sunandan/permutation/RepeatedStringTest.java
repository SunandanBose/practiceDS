package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedStringTest {

    RepeatedString rs = new RepeatedString();

    @Test
    public void test1MethodRepeatedString(){
        String input = "abab";
        assertEquals(true,rs.repeatedSubstringPattern(input));
    }

    @Test
    public void test2MethodRepeatedString(){
        String input = "aba";
        assertEquals(false,rs.repeatedSubstringPattern(input));
    }

    @Test
    public void test3MethodRepeatedString(){
        String input = "abcabcabcabc";
        assertEquals(true,rs.repeatedSubstringPattern(input));
    }

    @Test
    public void test4MethodRepeatedString(){
        String input = "abcab";
        assertEquals(false,rs.repeatedSubstringPattern(input));
    }


    // Recursion

    @Test
    public void test1MethodRepeatedStringUsingRecursion(){
        String input = "ababab";
        assertEquals(true,rs.repeatedSubstringPatternUsingRecursion(input));
    }

    @Test
    public void test2MethodRepeatedStringUsingRecursion(){
        String input = "abab";
        assertEquals(true,rs.repeatedSubstringPatternUsingRecursion(input));
    }

    @Test
    public void test3MethodRepeatedStringUsingRecursion(){
        String input = "aba";
        assertEquals(false,rs.repeatedSubstringPatternUsingRecursion(input));
    }

    @Test
    public void test4MethodRepeatedStringUsingRecursion(){
        String input = "abcab";
        assertEquals(false,rs.repeatedSubstringPatternUsingRecursion(input));
    }

    @Test
    public void test5MethodRepeatedStringUsingRecursion(){
        String input = "abcabc";
        assertEquals(true,rs.repeatedSubstringPatternUsingRecursion(input));
    }

}