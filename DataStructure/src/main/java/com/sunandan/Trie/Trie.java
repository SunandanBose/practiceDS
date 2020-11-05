package com.sunandan.Trie;

class Trie {

    /**
     * Initialize your data structure here.
     */
    TrieNode root = null;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int ascIIValue = ch - 'a';
            if (node.next[ascIIValue] == null)
                node.next[ascIIValue] = new TrieNode();
            node = node.next[ascIIValue];
        }
        node.word = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, word.length(), root);
    }

    private boolean search(char[] letters, int index, int totalLength, TrieNode node) {
        if (index >= totalLength) return false;
        char ch = letters[index];
        if (node.next[ch - 'a'] == null) return false;
        node = node.next[ch - 'a'];
        if (index == totalLength - 1) {
            if (node.word != null) {
                return true;
            }
        }
        return search(letters, index + 1, totalLength, node);
    }


    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix.toCharArray(), 0, prefix.length(), root);
    }

    private boolean startsWith(char[] letters, int index, int totalLength, TrieNode node) {
        if (index >= totalLength) return false;
        char ch = letters[index];
        if (node.next[ch - 'a'] == null) return false;
        node = node.next[ch - 'a'];
        if (index == totalLength - 1) {
            return true;
        }
        return startsWith(letters, index + 1, totalLength, node);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
