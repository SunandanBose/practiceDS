package com.sunandan.permutation;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        int arr[] = new int[s.length() + 1];
        int currIndex = 0, max = 0, validStart = 0;
        arr[0] = -1;
        while (currIndex < s.length()) {
            if (s.charAt(currIndex) == '(')
                arr[++validStart] = currIndex;
            else {
                if (validStart > 0)
                    max = Math.max(max, currIndex - arr[--validStart]);
                else
                    arr[0] = currIndex;
            }
            currIndex++;
        }
        return max;
    }


    // Brute Force
    public int longestValidParentheses1(String s) {
        if (s.length() == 0) return s.length();
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (CorrectParanthesis.checkParanthesis(s.substring(i, j)))
                    max = Math.max(max, s.substring(i, j).length());
            }
        }
        return max;
    }
}
