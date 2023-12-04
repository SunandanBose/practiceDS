package com.sunandan.permutation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // using HashSet
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> window = new HashSet<>();
        int n = s.length();
        if (n == 0)
            return 0;
        int i = 0, j = 0, maxValue = 0;
        while (i < n && j < n) {
            if (window.contains(s.charAt(j)))
                window.remove(s.charAt(i++));
            else {
                window.add(s.charAt(j++));
                maxValue = Math.max(maxValue, j - i);
            }
        }
        return maxValue;
    }

    // using HashMap
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        if (n == 0)
            return 0;
        int maxValue = 0;
        for (int j = 0, i = 0; j < n; j++) {
            if (map.get(s.charAt(j)) != null) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            maxValue = Math.max(maxValue, j - i + 1);

        }
        return maxValue;
    }

}
