package com.sunandan.permutation;

import java.util.*;
import java.util.stream.Collectors;

public class MarksAndTime {


    public static void main(String[] args) {
        int totalHours = 10;
        Map<Integer, Integer> timeMarks = new HashMap<>();
        timeMarks.put(6, 4);
        timeMarks.put(4, 6);
        timeMarks.put(2, 2);
        timeMarks.put(7, 8);
        int maxValue = calculate(totalHours, timeMarks);
        System.out.println(maxValue);
    }

    private static int calculate(int totalHours, Map<Integer, Integer> timeMarks) {
        int maxValue = Integer.MIN_VALUE;
        List<List<Integer>> combinations = getCombinations(timeMarks.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()), totalHours, totalHours);
        for(List<Integer> combination : combinations){
            int marks = getTotalMarks(combination, timeMarks);
            maxValue = Math.max(maxValue, marks);
        }
        return maxValue;
    }

    private static int getTotalMarks(List<Integer> combination, Map<Integer, Integer> timeMarks) {
        int totalMarks = 0;
        for (int i = 0; i < combination.size(); i++) {
            totalMarks += timeMarks.get(combination.get(i));
        }
        return totalMarks;
    }

    private static List<List<Integer>> getCombinations(List<Integer> timeList, int totalleft, int totalHours) {
        List<List<Integer>> result = new ArrayList<>();
        if(totalleft <= 0) return result;
        for (int i = 0; i < timeList.size(); i++) {
            if (i == timeList.size() - 1) {
                if(totalleft > timeList.get(i) && totalHours != totalleft)
                    return new ArrayList<>(Collections.singletonList(new ArrayList<>(Collections.singletonList(timeList.get(i)))));
                return result;
            }
            if (timeList.get(i) == totalleft) {
                return new ArrayList<>(Collections.singletonList(new ArrayList<>(Collections.singletonList(timeList.get(i)))));
            }
            List<Integer> combination = new ArrayList<>();
            combination.add(timeList.get(i));
            List<List<Integer>> combinations = getCombinations(timeList, totalleft - timeList.get(i), totalHours);
            for (List<Integer> intermediateCombination : combinations) {
                intermediateCombination.addAll(combination);
            }
            result.addAll(combinations);
        }
        return result;
    }
}
