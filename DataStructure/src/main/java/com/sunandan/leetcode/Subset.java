package com.sunandan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

    public List<String> StringSubsets(String nums) {
        List<String> result = new ArrayList<>();
        result.add("");
        for(char ch : nums.toCharArray()){
            int size = result.size();
            for(int i = 0; i < size; i++){
                String temp = result.get(i);
                result.add(temp+ch);
            }
        }
        return result;
    }

}
