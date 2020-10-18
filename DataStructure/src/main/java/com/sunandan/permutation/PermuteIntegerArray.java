package com.sunandan.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteIntegerArray {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(new ArrayList<>(Collections.singletonList(new ArrayList<>(Collections.singletonList(nums[0])))));
        while (result.get(0).size() < nums.length) {
            List<Integer> tempList = result.get(0);
            result.addAll(addInteger(tempList, nums[tempList.size()]));
            result.remove(0);
        }
        return result;
    }


    private List<List<Integer>> addInteger(List<Integer> input, int value) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= input.size(); i++) {
            List<Integer> combination = new ArrayList<>();
            combination.addAll(input);
            combination.add(i, value);
            result.add(combination);
        }
        return result;
    }

}
