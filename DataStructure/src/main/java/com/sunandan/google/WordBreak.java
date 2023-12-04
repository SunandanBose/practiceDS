package com.sunandan.google;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        for(int i = 0; i<s.length()-1; i++){
            if(wordDict.contains(s.substring(0,i+1)) && wordBreak(s.substring(i+1),wordDict))
                return true;
        }
        return false;
    }

}
