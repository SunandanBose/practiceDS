package com.sunandan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), s);
        return result;

    }

    private void dfs(int start, List<List<String>> result, List<String> currList, String str) {
        if (start >= str.length())
            result.add(new ArrayList<>(currList));
        for (int end = start; end < str.length(); end++) {
            String tempString = str.substring(start, end + 1);
            if (isPalindrome(tempString)) {
                currList.add(tempString);
                dfs(end + 1, result, currList, str);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String input) {
        for (int i = 0; i < (input.length() / 2); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                return false;
        }
        return true;
    }

}
