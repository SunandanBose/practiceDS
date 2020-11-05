package com.sunandan.Trie;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    private Trie trie = new Trie();


    @Test
    public void testSearch() {
        trie.insert("apple");
        Boolean actual = trie.search("apple");
        assertEquals(true, actual);
    }

    @Test
    public void test2Search() {
        trie.insert("apple");
        Boolean actual = trie.search("appl");
        assertEquals(false, actual);
    }

    @Test
    public void testStartsWith() {
        trie.insert("apple");
        Boolean actual = trie.startsWith("app");
        assertEquals(true, actual);
    }

    @Test
    public void test2StartsWith() {
        trie.insert("apple");
        Boolean actual = trie.startsWith("apl");
        assertEquals(false, actual);
    }
}