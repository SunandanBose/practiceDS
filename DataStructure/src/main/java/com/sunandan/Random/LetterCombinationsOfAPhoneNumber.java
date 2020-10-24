package com.sunandan.Random;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> phoneLetterMap = new HashMap<>();
        phoneLetterMap.putAll(populateMap(phoneLetterMap));
        getPermutations(digits, "", phoneLetterMap);
        return result;
    }

    private void getPermutations(String digits, String prefix, Map<Character, List<String>> phoneLetterMap) {
        if (digits.length() == 0) return;
        if (digits.length() == 1) {
            for (String str : phoneLetterMap.get(digits.charAt(0))) {
                result.add(prefix + str);
            }
            return;
        }
        for (String str : phoneLetterMap.get(digits.charAt(0))) {
            getPermutations(digits.substring(1), prefix + str, phoneLetterMap);
        }
    }

    private Map<Character, List<String>> populateMap(Map<Character, List<String>> phoneLetterMap) {
        phoneLetterMap = new HashMap<>();
        phoneLetterMap.put('2', Arrays.asList("a", "b", "c"));
        phoneLetterMap.put('3', Arrays.asList("d", "e", "f"));
        phoneLetterMap.put('4', Arrays.asList("g", "h", "i"));
        phoneLetterMap.put('5', Arrays.asList("j", "k", "l"));
        phoneLetterMap.put('6', Arrays.asList("m", "n", "o"));
        phoneLetterMap.put('7', Arrays.asList("p", "q", "r", "s"));
        phoneLetterMap.put('8', Arrays.asList("t", "u", "v"));
        phoneLetterMap.put('9', Arrays.asList("w", "x", "y", "z"));
        return phoneLetterMap;
    }

}
