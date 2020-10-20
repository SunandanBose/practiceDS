package com.sunandan.Random;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/single-number/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(freq.get(nums[i]) == null)
                freq.put(nums[i], 0);
            freq.put(nums[i], freq.get(nums[i])+1);
        }
        for(Integer i : freq.keySet()){
            if(freq.get(i) == 1)
                return i;
        }
        return 1;
    }

}
