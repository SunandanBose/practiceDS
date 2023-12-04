package com.sunandan.leetcode;

import java.util.Arrays;

public class GoatLatin {

    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+");
        for(int i = 0 ; i < words.length ; i++){
            StringBuilder word = new StringBuilder(words[i]);
            if(!isVowel(word.charAt(0))){
                char firstChar = word.charAt(0);
                word = word.deleteCharAt(0);
                word.append(firstChar);
            }
            word.append("ma");
            char[] repeatA = new char[i+1];
            Arrays.fill(repeatA, 'a');
            word.append(String.valueOf(repeatA));
            words[i] = word.toString();
        }
        return String.join(" ", words);
    }

    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'){
            return true;
        }
        return false;
    }

}
