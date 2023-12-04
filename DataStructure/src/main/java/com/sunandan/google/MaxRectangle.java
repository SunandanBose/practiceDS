package com.sunandan.google;

import java.util.*;
import java.util.stream.Collectors;

public class MaxRectangle {

    public int getMaxAreaOfRectangle(int[][] matrix){
        int maxArea = 0, maxAreaOfRow;
        Integer[] histogramGraph = new Integer[matrix[0].length];
        Arrays.fill(histogramGraph,0);
        for(int i=0; i<matrix.length; i++){
            histogramGraph = getHistogramOfRow(matrix, i, histogramGraph);
            maxAreaOfRow = findMaxAreaInHistogram(new ArrayList<Integer>(Arrays.asList(histogramGraph)));
            maxArea = Math.max(maxArea,maxAreaOfRow);
        }
        return maxArea;
    }

    private Integer[] getHistogramOfRow(int[][] matrix, int row_index, Integer[] result) {
        for(int column=0; column<matrix[0].length; column++){
            if(matrix[row_index][column] == 0){
                result[column] = 0;
                continue;
            }
            result[column] += 1;
        }
        return result;
    }

    public Integer findMaxAreaInHistogram(List<Integer> histogram){
        Set<Integer> uniqueValues = histogram.stream().filter(x -> x!=0).collect(Collectors.toCollection(TreeSet::new));
        int sum = 0, maxArea = 0;
        for(Integer value : uniqueValues){
            for(int i =0; i<histogram.size();i++){
                if(value <= histogram.get(i))
                    sum += value;
                else{
                    maxArea = Math.max(sum,maxArea);
                    sum = 0;
                }
            }
            maxArea = Math.max(sum,maxArea);
            sum=0;
        }
        return maxArea;
    }


}
