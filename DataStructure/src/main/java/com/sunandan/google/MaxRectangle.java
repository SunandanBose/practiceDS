package com.sunandan.google;

import java.util.*;
import java.util.stream.Collectors;

public class MaxRectangle {

    private Histogram histogram = new Histogram();

    public int getMaxAreaOfRectangle(int[][] matrix){
        int maxArea = 0, maxAreaOfRow;
        Integer[] histogramGraph = new Integer[matrix[0].length];
        Arrays.fill(histogramGraph,0);
        for(int i=0; i<matrix.length; i++){
            histogramGraph = getHistogramOfRow(matrix, i, histogramGraph);
            maxAreaOfRow = histogram.calculateMaxAreaOfHistogram(new ArrayList<Integer>(Arrays.asList(histogramGraph)));
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
}
