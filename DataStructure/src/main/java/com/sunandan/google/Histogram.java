package com.sunandan.google;

import java.util.*;
import java.util.stream.Collectors;

public class Histogram {

    public int calculateMaxAreaOfHistogram(List<Integer> input) {
        Set<Integer> sortedNonDuplicateValues = input.stream().filter(x -> x!=0).collect(Collectors.toCollection(TreeSet::new));
        Integer[] sortedNonDuplicateValuesArray = sortedNonDuplicateValues.toArray(new Integer[sortedNonDuplicateValues.size()]);
        List<List<Integer>> areaCombination = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int count = 0;
        while(count < sortedNonDuplicateValuesArray.length) {
            for (int i = 0; i < input.size(); i++) {
                if (sortedNonDuplicateValuesArray[count] <= input.get(i)) {
                    tempList.add(input.get(i));
                } else {
                    if(tempList.size()>0)
                        areaCombination.add(tempList);
                    tempList = new ArrayList<>();
                }
            }
            if(tempList.size()>0) areaCombination.add(tempList);
            tempList = new ArrayList<>();
            count ++;
        }
        return getMaxArea(areaCombination);
    }

    private int getMaxArea(List<List<Integer>> areaCombination) {
        int maxArea = 0, area;
        for(int i=0; i< areaCombination.size(); i++){
            Collections.sort(areaCombination.get(i));
            area = areaCombination.get(i).size() * areaCombination.get(i).get(0);
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

}
