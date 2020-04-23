package com.sunandan.permutation;

public class CommonChild {

    public int getCommonChild(String s1, String s2) {
        int[][] commonLengthArray = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    commonLengthArray[i + 1][j + 1] = commonLengthArray[i][j] + 1;
                else {
                    commonLengthArray[i + 1][j + 1] = Math.max(commonLengthArray[i][j + 1], commonLengthArray[i + 1][j]);
                }
            }
        }
        return commonLengthArray[s1.length()][s2.length()];
    }
}
// https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
//                  A	E	A	D
//              0	0	0	0	0
//           A	0	1	1	1	1
//           B	0	1	1	1	1
//           C	0	1	1	1	1
//           D	0	1	1	1	2