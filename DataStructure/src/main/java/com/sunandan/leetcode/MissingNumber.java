package com.sunandan.leetcode;


public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        int n = nums.length;
        return ((n * (n + 1)) / 2) - sum;
    }

}
