package com.sunandan.google;

import java.util.*;
import java.util.stream.*;

public class DistinctSubsequence {

    public static String originalString;

    public int getDistinctSubsequences(String longString, String shortString) {
        DistinctSubsequence.originalString = longString;
        Map<Character, List<Integer>> positionCharacterFreqMap = getPositionOfCharacters(longString, shortString);
        return findSubsequence(positionCharacterFreqMap, shortString, longString);
    }

    private int findSubsequence(Map<Character, List<Integer>> positionCharacterFreqMap, String searchString, String remainingString) {
        int result = 0;
        Character ch = searchString.charAt(0);
        int startValue = originalString.length() - remainingString.length();
        List<Integer> freqOfCharacters = getCharactersIndex(positionCharacterFreqMap.get(ch), startValue);
        if (freqOfCharacters == null) return 0;
        for (Integer i : freqOfCharacters) {
            if (searchString.length() == 1)
                return 1 + findSubsequence(positionCharacterFreqMap, searchString, originalString.substring(i + 1));
            result += findSubsequence(positionCharacterFreqMap, searchString.substring(1), originalString.substring(i + 1));
        }
        return result;
    }

    private List<Integer> getCharactersIndex(List<Integer> list, int startValue) {
        if (list == null) return null;
        return list.stream().filter(x -> x >= startValue).collect(Collectors.toList());
    }

    private Map<Character, List<Integer>> getPositionOfCharacters(String longString, String shortString) {
        Map<Character, List<Integer>> positionCharacterFreqMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        shortString.chars().distinct().forEach(x -> sb.append((char) x));
        shortString = sb.toString();
        for (int i = 0; i < shortString.length(); i++) {
            for (int j = 0; j < longString.length(); j++) {
                if (shortString.charAt(i) == longString.charAt(j)) {
                    if (positionCharacterFreqMap.get(shortString.charAt(i)) == null)
                        positionCharacterFreqMap.put(shortString.charAt(i), new ArrayList<>());
                    List<Integer> tempList = positionCharacterFreqMap.get(shortString.charAt(i));
                    tempList.add(j);
                    positionCharacterFreqMap.put(shortString.charAt(i), tempList);
                }
            }
        }
        return positionCharacterFreqMap;
    }
}
