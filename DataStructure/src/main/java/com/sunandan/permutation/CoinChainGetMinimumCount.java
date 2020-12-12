package com.sunandan.permutation;

import java.util.HashMap;
import java.util.Map;

public class CoinChainGetMinimumCount {

    Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int finalAmount) {
        if(finalAmount == 0) return finalAmount;
        if(cache.get(finalAmount) != null) return cache.get(finalAmount);
        int minCount = Integer.MAX_VALUE;
        for(int i = coins.length-1; i >= 0; i--){
            if(finalAmount == coins[i])
                return 1;
            if(coins[i] < finalAmount){
                int count = 0;
                count = coinChange(coins, finalAmount-coins[i]);
                if(count != -1)
                    minCount = Math.min(minCount,1 + count);
            }
        }
        cache.put(finalAmount, minCount == Integer.MAX_VALUE ? -1 : minCount);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }


}
