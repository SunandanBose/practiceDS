package com.sunandan.Random;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i]))
                result.add(nums2[i]);
        }
        int[] ans = new int[result.size()];
        int count = 0;
        for(Integer i : result){
            ans[count++] = i;
        }
        return ans;
    }
}
