package com.sunandan.permutation;

import java.util.*;

public class Anagram {


    public Map<String,Integer> getAnagramsInList(List<String> list){
        Map<String,Integer> map = new HashMap<>();
        List<String> sortedList = SortListOfString(list);
        for(int i=0;i<sortedList.size();i++){
            if(map.get(sortedList.get(i))==null){
                map.put(sortedList.get(i),1);
            }
            else {
                map.put(sortedList.get(i),map.get(sortedList.get(i))+1);
            }
        }
        return map;
    }

    private List<String> SortListOfString(List<String> originallist) {
        List<String> list = new ArrayList<>();
        char[] c;
        for(int i=0;i<originallist.size();i++){
            c = originallist.get(i).toCharArray();
            Arrays.sort(c);
            list.add(String.valueOf(c));
        }
        return list;
    }
}
