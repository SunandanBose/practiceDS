package com.sunandan.permutation;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int getLongestCommonSubsequenceCount(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i= 0; i<str1.length(); i++){
            for(int j = 0; j <str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public String getLongestCommonSubsequenceString(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        StringBuilder result = new StringBuilder();
        int max = 0;
        for(int i= 0; i<str1.length(); i++){
            for(int j = 0; j <str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                    if(max < dp[i+1][j+1]) {
                        max = dp[i+1][j+1];
                        result.append(str2.charAt(j));
                    }
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return result.toString();
    }

}
