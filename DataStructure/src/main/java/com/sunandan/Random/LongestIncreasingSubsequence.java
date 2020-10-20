package com.sunandan.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int getCount(List<Integer> input){
        return getCount(input, Integer.MIN_VALUE, 0);
    }

    private int getCount(List<Integer> input, int prev, int curr){
        if(curr >= input.size()){
            return 0;
        }
        int count1 = 0;
        if(input.get(curr) > prev)
            count1 = 1 +  getCount(input, input.get(curr) , curr+1);
        int count2 = getCount(input, prev, curr+1);
        return Math.max(count1, count2);
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = ~pile;
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size();
    }

    private int[] dp = null;
    public int lengthOfLISDP(int[] nums) {
        dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for(int i = 1; i < nums.length ; i++){
            int len = 0;
            for(int j = 0 ; j < i; j++){
                if(nums[i]>nums[j]){
                    len = Math.max(len, dp[j]);
                }
            }
            dp[i] = len+1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
