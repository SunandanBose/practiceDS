package com.sunandan.google;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        LinkedList<int[]> result = new LinkedList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            if(result.isEmpty() || result.getLast()[1] < intervals[i][0])
                result.add(intervals[i]);
            else
                result.getLast()[1] = Math.max(result.getLast()[1],intervals[i][1]);
        }
        return result.toArray(new int[result.size()][2]);
    }

}
