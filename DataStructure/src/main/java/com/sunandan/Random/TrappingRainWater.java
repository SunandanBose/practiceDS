package com.sunandan.Random;

public class TrappingRainWater {

    public int trap1(int[] height) {
        int trap = 0;
        for(int i = 1; i < height.length; i++){
            int left_max =0, right_max = 0;
            for(int j = i; j >= 0; j--){
                left_max = Math.max(left_max, height[j]);
            }
            for(int j = i; j< height.length ; j++){
                right_max = Math.max(right_max, height[j]);
            }
            trap += Math.min(left_max, right_max) - height[i];
        }
        return trap;
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int trap = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        right_max[height.length-1] = height[height.length-1];
        for(int i = 1; i < height.length; i++){
            left_max[i] = Math.max(left_max[i-1], height[i]);
        }
        for(int i = height.length-2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i+1], height[i]);
        }
        for(int i = 0; i < height.length; i++){
            trap += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return trap;
    }

}
