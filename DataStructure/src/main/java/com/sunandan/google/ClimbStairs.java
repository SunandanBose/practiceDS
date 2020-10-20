package com.sunandan.google;

//https://leetcode.com/problems/climbing-stairs/submissions/
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){
            return n;
        }
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i = 2; i < n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }

}
