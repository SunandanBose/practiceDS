package com.sunandan.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakIITest {

    private WordBreakII wordBreakII = new WordBreakII();

    @Test
    public void test1wordBreak() {
        String sInput = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> expected = Arrays.asList("cats and dog", "cat sand dog");
        List<String> actual = wordBreakII.wordBreak(sInput,wordDict);
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test2WordBreakII() {
        String sInput = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog","sa","nd");
        List<String> expected = Arrays.asList("cat sa nd dog", "cat sand dog", "cats and dog");
        List<String> actual = wordBreakII.wordBreak(sInput,wordDict);
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test3WordBreakII() {
        String sInput = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> expected = Arrays.asList();
        List<String> actual = wordBreakII.wordBreak(sInput,wordDict);
        assertEquals(expected, actual);
    }

    @Test
    public void test4WordBreakII() {
        String sInput = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> expected = Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
        List<String> actual = wordBreakII.wordBreak(sInput,wordDict);
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);
    }
}