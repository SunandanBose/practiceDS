package com.sunandan.leetcode;

//https://leetcode.com/problems/find-the-duplicate-number/
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        int index = 0;
        while(nums[index] > 0){
            int tempIndex = nums[index];
            nums[index] = (-1) * nums[index];
            index = tempIndex;
        }
        return index;
    }

}
