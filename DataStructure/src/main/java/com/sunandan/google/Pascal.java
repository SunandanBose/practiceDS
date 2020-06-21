package com.sunandan.google;

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
}
