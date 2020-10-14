package com.sunandan.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("()");
        while (n > 1) {
            Set<String> uniqueSet = new HashSet<>();
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < result.get(i).length(); j++) {
                    String s = result.get(i);
                    uniqueSet.add(s.substring(0, j) + "()" + s.substring(j));
                }
            }
            result = new ArrayList<>();
            result.addAll(uniqueSet);
            n--;
        }
        return result;
    }
}
