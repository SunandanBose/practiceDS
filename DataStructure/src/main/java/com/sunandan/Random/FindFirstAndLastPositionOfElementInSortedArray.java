package com.sunandan.Random;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        for(int start = 0; start < nums.length ; start++){
            if(nums[start] == target){
                for(int end = nums.length-1; end >= start ; end--){
                    if(nums[end] == target){
                        return new int[]{start,end};
                    }
                }
            }
        }
        return new int[]{-1,-1};
    }

}
