package com.sunandan.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WordBreakTest {

    private WordBreak wb = new WordBreak();

    @Test
    public void test1MethodWordBreak() {
        String[] input = {"aaaa", "aaa"};
        assertEquals(true,wb.wordBreak("aaaaaaa", Arrays.asList(input)));
    }

    @Test
    public void test2MethodWordBreak() {
        String[] input = {"leet", "code"};
        assertEquals(true,wb.wordBreak("leetcode", Arrays.asList(input)));
    }


    @Test
    public void test3MethodWordBreak() {
        String[] input = {"trainer", "my", "interview"};
        assertEquals(true,wb.wordBreak("myinterviewtrainer", Arrays.asList(input)));
    }

    @Test
    public void test4MethodWordBreak() {
        String[] input = {"aaaa"};
        assertEquals(false,wb.wordBreak("a", Arrays.asList(input)));
    }

    @Test
    public void test5MethodWordBreak() {
        String[] input = {"a","b"};
        assertEquals(true,wb.wordBreak("ab", Arrays.asList(input)));
    }

}