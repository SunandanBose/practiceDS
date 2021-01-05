package com.sunandan.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        List<String> set = calculateSubset(tiles);
        return set.size() - 1;
    }

    private List<String> calculateSubset(String input) {
        List<String> subset = new ArrayList<>();
        subset.add(" ");
        for (int i = 0; i < input.length(); i++) {
            List temp = new ArrayList();
            for (int j = 0; j < subset.size(); j++) {
                temp.addAll(insert(subset.get(j), input.charAt(i)));
            }
            subset.addAll(temp);
            subset = subset.stream().distinct().collect(Collectors.toList());
        }
        return subset;
    }

    private List<String> insert(String str1, Character str2) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            String output = str1.substring(0, i) + String.valueOf(str2) + str1.substring(i);
            result.add(output);
        }
        return result;
    }

}
