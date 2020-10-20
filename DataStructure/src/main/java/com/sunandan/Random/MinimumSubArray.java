package com.sunandan.Random;

public class MinimumSubArray {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int startPointer = 0;
        int endPointer = 0;
        int sum = 0;
        while(endPointer < nums.length){
            sum += nums[endPointer++];
            while(sum >= s){
                ans = Math.min(ans, endPointer-startPointer);
                sum -= nums[startPointer++];
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
