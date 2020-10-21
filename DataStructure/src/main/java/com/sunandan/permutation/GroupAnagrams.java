package com.sunandan.permutation;

import java.util.*;

//Time Complexity: O(NK log K) N = length of strs, K = largest String length
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0) return result;
        if(strs.length == 1) return new ArrayList(Collections.singletonList(new ArrayList(Collections.singletonList(strs[0]))));
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String temp = String.valueOf(chs);
            if(map.get(temp) == null){
                map.put(temp, new ArrayList(Collections.singletonList(str)));
                continue;
            }
            List<String> existingList = map.get(temp);
            existingList.add(str);
            map.put(temp, existingList);
        }
        for(String str : map.keySet()){
            result.add(map.get(str));
        }
        return result;
    }

}
