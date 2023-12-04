package com.sunandan.permutation;

import com.sunandan.leetcode.Subset;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LongestWord {

    private Subset subset = new Subset();
    Permutation permutation = new Permutation();

    public List<String> getlongestWord(String letters, List<String> dictionary){
        List<String> result = new ArrayList<>();
        List<String> subsets = subset.StringSubsets(letters);
        List<String> tempIterator = new ArrayList<>(subsets);
        for(String str : tempIterator){
            if(str.length() > 1)
                subsets.addAll(permutation.getPermutation(str));
        }
        int maxLength = 0;
        for(String str : subsets){
            if(dictionary.contains(str)){
                maxLength = Math.max(maxLength, str.length());
                result.add(str);
            }
        }
        int finalMaxLength = maxLength;
        return result.stream().filter(str -> str.length() == finalMaxLength).collect(Collectors.toList());
//        return result;
    }
}
