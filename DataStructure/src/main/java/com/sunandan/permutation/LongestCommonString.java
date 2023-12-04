package com.sunandan.permutation;

public class LongestCommonString {

    public int getLongestCommonSubstring(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for(int i= 0; i<str1.length(); i++){
            for(int j = 0; j <str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestCommonString().getLongestCommonSubstring("ageek","geekForgeeks");
    }

}
