package com.sunandan.Random;

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        for(int i = 1 ; i <= nums.length-1; i++){
            int size = nums.length;
            if(nums[i-1]>nums[i] )
                return nums[i];
            if(nums[size-1-i] > nums[size-i])
                return nums[size-i];
        }
        return nums[0];
    }
}
