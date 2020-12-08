package com.sunandan.Random;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int n = height.length;
        int max = Math.min(height[0], height[n-1]) * (n-1);
        int left = 0, right = n - 1;
        while(left < right){
            max = Math.max(max, (Math.min(height[left], height[right]) * (right - left)));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }

}
