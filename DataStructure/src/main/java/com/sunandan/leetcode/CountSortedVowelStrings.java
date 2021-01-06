package com.sunandan.leetcode;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while (n > 1) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            n--;
        }
        return a + e + i + o + u;
    }

// n = 2
// a = 1 * 5 // including a
// e = 1 * 4 // can't include a as it has to be in lexicographically order
//same for i, o, u

}
