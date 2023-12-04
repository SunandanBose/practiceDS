package com.sunandan.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = getWordsInTrieNodeDSFormat(words);
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[0].length; columnIndex++) {
                search(board, rowIndex, columnIndex, root, result);
            }
        }
        return result;
    }

    //DFS search
    private void search(char[][] board, int rowIndex, int columnIndex, TrieNode root, List<String> foundWords) {
        char ch = board[rowIndex][columnIndex];
        if (ch == '#' || root.next[ch - 'a'] == null) return;
        root = root.next[ch - 'a'];
        if (root.word != null) {   // found the word
            foundWords.add(root.word);
            root.word = null;
        }

        board[rowIndex][columnIndex] = '#'; // changing the value to hash. So that it is marked as visited
        if (rowIndex > 0)
            search(board, rowIndex - 1, columnIndex, root, foundWords); // Move left direction
        if (columnIndex > 0)
            search(board, rowIndex, columnIndex - 1, root, foundWords); // Move up  direction
        if (rowIndex < board.length - 1)
            search(board, rowIndex + 1, columnIndex, root, foundWords); // Move right  direction
        if (columnIndex < board[0].length - 1)
            search(board, rowIndex, columnIndex + 1, root, foundWords); // Move down  direction
        board[rowIndex][columnIndex] = ch; // changing the value back to the original character. after searching around it
    }

    private TrieNode getWordsInTrieNodeDSFormat(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            // charAt is faster than toCharArray()
            //for (char ch : word.toCharArray()) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int ascIIValue = ch - 'a';
                if (node.next[ascIIValue] == null)
                    node.next[ascIIValue] = new TrieNode();
                node = node.next[ascIIValue];
            }
            node.word = word;
        }
        return root;
    }
}
