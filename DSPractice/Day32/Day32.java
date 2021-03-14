import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.text.normalizer.Trie;

public class Day32 {

    public static void main(String[] args) {
        Day32 day32 = new Day32();
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        List<String> wordDict = Arrays.asList("oath", "pea", "eat", "rain");
        List<String> result = day32.wordSearch(board, wordDict);
        System.out.println(result);
    }

    public List<String> wordSearch(final char[][] board, final List<String> wordDictionary) {
        List<String> result = new ArrayList<>();
        TrieNode head = getDictInTrieNode(wordDictionary);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                wordSearch(board, i, j, head, result);
            }

        }
        return result;
    }

    private void wordSearch(final char[][] board, int rowIndex, int colIndex, TrieNode root, List<String> foundWords) {
        char ch = board[rowIndex][colIndex];
        if (ch == '#' || root.nodes[ch - 'a'] == null)
            return;
        root = root.nodes[ch - 'a'];
        if (root.word != null) {
            foundWords.add(root.word);
            root.word = null;
        }
        board[rowIndex][colIndex] = '#';
        if (rowIndex > 0)
            wordSearch(board, rowIndex - 1, colIndex, root, foundWords);
        if (rowIndex < board.length - 1)
            wordSearch(board, rowIndex + 1, colIndex, root, foundWords);
        if (colIndex > 0)
            wordSearch(board, rowIndex, colIndex - 1, root, foundWords);
        if (colIndex < board[0].length - 1)
            wordSearch(board, rowIndex, colIndex + 1, root, foundWords);
        board[rowIndex][colIndex] = ch;

    }

    private TrieNode getDictInTrieNode(final List<String> wordDictionary) {
        TrieNode head = new TrieNode();
        for (String word : wordDictionary) {
            TrieNode node = head;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int ascValue = ch - 'a';
                if (node.nodes[ascValue] == null) {
                    node.nodes[ascValue] = new TrieNode();
                }
                node = node.nodes[ascValue];
            }
            node.word = word;
        }
        return head;
    }

}

class TrieNode {
    TrieNode[] nodes = new TrieNode[26];
    String word = null;
}