package com.sunandan.dynamicprogramming;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[col - 1];
    }

}
