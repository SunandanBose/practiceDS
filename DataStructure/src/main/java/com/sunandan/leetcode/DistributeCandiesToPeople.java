package com.sunandan.leetcode;

public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int count = 1;
        while(candies > 0){
            ans[(count-1)%num_people] += candies > count ? count : candies;
            candies -= count;
            count ++;
        }
        return ans;
    }

}
