package com.sunandan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character,Integer> freq = getFrequency(s);
        int count = 0;
        boolean isOddFreqPresent = false;
        for(Character i : freq.keySet()){
            if(freq.get(i)%2==0)
                count+=freq.get(i);
            else{
                count+=freq.get(i)-1;
                isOddFreqPresent = true;
            }
        }
        return isOddFreqPresent ? count+1 : count;
    }

    public Map<Character,Integer> getFrequency(String input){
        Map<Character,Integer> freq = new HashMap();
        for(int i = 0 ; i < input.length() ; i++){
            if(freq.get(input.charAt(i)) == null)
                freq.put(input.charAt(i), 0);
            freq.put(input.charAt(i), freq.get(input.charAt(i))+1);
        }
        return freq;
    }

}
