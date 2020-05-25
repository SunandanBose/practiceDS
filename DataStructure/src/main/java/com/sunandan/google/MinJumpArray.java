package com.sunandan.google;

public class MinJumpArray {

    public int getMinJump(int[] inputNumbers) {
        int minJump = 0, currentEnd = 0, currentFarthest = 0;
        for (int i = 0; i < inputNumbers.length-1; i++) {
            currentFarthest = Math.max(currentFarthest, i + inputNumbers[i]);
            if (i == currentEnd) {
                minJump++;
                currentEnd = currentFarthest;
            }
        }
        return minJump;
    }

}
