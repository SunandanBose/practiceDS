package com.sunandan.leetcode;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public static int rob(int[] nums, int start, int end) {
        int ifCurrentPreviousRobbed = 0;
        int ifCurrentPreviousNotRobbed = 0;
        for (int i = start; i < end; i++) {
            int currRobbed = ifCurrentPreviousNotRobbed + nums[i];
            int currentNotRobbed = Math.max(ifCurrentPreviousRobbed, ifCurrentPreviousNotRobbed);

            ifCurrentPreviousRobbed = currRobbed;
            ifCurrentPreviousNotRobbed = currentNotRobbed;
        }
        return Math.max(ifCurrentPreviousRobbed, ifCurrentPreviousNotRobbed);
    }

}
