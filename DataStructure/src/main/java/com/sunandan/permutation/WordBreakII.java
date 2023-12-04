package com.sunandan.permutation;

import java.util.*;

public class WordBreakII {

    private Map<String, List<String>> internalCache = new HashMap();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (internalCache.containsKey(s))
            return internalCache.get(s);
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s))
            result.add(s);
        for (int i = 1; i < s.length(); i++) {
            String LHS = s.substring(0, i);
            if (wordDict.contains(LHS)) {
                List<String> RHS = wordBreak(s.substring(i), wordDict);
                for (String str : RHS) {
                    result.add(LHS + " " + str);
                }
            }
        }
        internalCache.put(s, result);
        return result;
    }
}