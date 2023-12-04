package com.sunandan.leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int diff = (a[1]-a[0])-(b[1]-b[0]);
            if(diff == 0)
                return a[0]-b[0];
            return diff;
        });
        if(intervals.length == 0 || intervals[0].length == 0) return 0;
        int min = intervals[0][0];
        int max = intervals[0][1];
        int minCount = 0;
        for(int i = 1; i< intervals.length; i++){
            if(isWithinRange(intervals[i][1],min,max) || isWithinRange(intervals[i][0],min,max) ||
                    min == intervals[i][0] || max == intervals[i][1]){
                minCount += 1;
                continue;
            }
            max= Math.max(max,intervals[i][1]);
            min= Math.min(min,intervals[i][0]);
        }
        return minCount;
    }

    private boolean isWithinRange(int value, int min, int max){
        if(value > min && value < max)
            return true;
        return false;
    }
}
