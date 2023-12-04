package com.sunandan.Random;

import java.util.*;

public class PerfectSquares {

    Map<Integer, Integer> dp = new HashMap<>();

    public int numSquares(int n) {
        if(n <= 1) return n;
        if(dp.get(n) != null)
            return dp.get(n);
        int limit = (int)Math.sqrt(n);
        int minCount = Integer.MAX_VALUE;
        for(int i = limit; i>=1; i--){
            int square = i*i;
            if(n - square >= 0){
                minCount = Math.min(minCount, 1 + numSquares(n- square));
            }
        }
        dp.put(n, minCount);
        return minCount;
    }


    // faster solution
    public int numSquares2(int n) {
        int[] dp1 = new int[n + 1];
        Arrays.fill(dp1, Integer.MAX_VALUE);
        dp1[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp1[i - j*j] + 1);
                ++j;
            }
            dp1[i] = min;
        }
        return dp1[n];
    }

}
