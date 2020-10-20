package com.sunandan.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {

    public int[] getKthRowInPascal(int k) {
        int[] result = new int[k + 1];
        result[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j >= 1; j--) {
                result[j] += result[j - 1];
            }
        }
        return result;
    }

    public List<List<Integer>>  generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0 ) return result;
        result.add(Arrays.asList(1));
        for(int i = 1; i < numRows ; i++){
            List<Integer> prevRow = result.get(i-1);
            List<Integer> presentRow = new ArrayList(prevRow);
            presentRow.add(i,1);
            for(int j = i-1; j >= 1; j--){
                presentRow.set(j,presentRow.get(j-1)+presentRow.get(j));
            }
            result.add(presentRow);
        }
        return result;
    }
}
