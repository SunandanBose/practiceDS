package com.sunandan.Trie;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchTest {

    private WordSearch wordSearch = new WordSearch();

    @Test
    public void test1findWords() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> expected = Arrays.asList("oath","eat");
        assertEquals(expected,wordSearch.findWords(board,words));
    }
}