package com.sunandan.permutation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConstructPermutationString {

    public boolean canConstruct(String s, int k) {
        int countOddFreqCharacters = 0;
        if (s.length() < k) return false;
        Map<Character, Integer> frequencyMap = getStringFrequencyInMap(s);
        for (Character ch : frequencyMap.keySet()) {
            if (frequencyMap.get(ch) % 2 != 0) countOddFreqCharacters++;
        }
        if (countOddFreqCharacters <= k) return true;
        return false;
    }

    private Map<Character, Integer> getStringFrequencyInMap(String s) {
        Map<Character, Integer> charToFreqMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (charToFreqMap.get(ch) != null)
                charToFreqMap.put(ch, charToFreqMap.get(ch) + 1);
            else {
                charToFreqMap.put(ch, 1);
            }
        }
        return charToFreqMap;
    }
}
