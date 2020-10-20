package com.sunandan.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(freq.get(nums[i]) == null)
                freq.put(nums[i], 0);
            freq.put(nums[i], freq.get(nums[i])+1);
        }
        for(Integer i : freq.keySet()){
            if(freq.get(i) > nums.length/3)
                result.add(i);
        }
        return result;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        String short1 =  new String("abc");
        String long = text2;
        if(text2.length() < text1.length()){
            short = text2;
            long = text1;
        }
        int count = short
        int ans = 0;
        for(int i = 0; i < long.length() ; i++){
            if(long.charAt(i) == short.charAt(count)){
                ans ++;
                count ++;
            }
        }
        return ans;
    }


}
