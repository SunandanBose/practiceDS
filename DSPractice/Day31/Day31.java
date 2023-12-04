import java.util.*;

/**
 * Day31
 */
public class Day31 {

    public static void main(String[] args) {
        Day31 day31 = new Day31();
        int[][] input = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int output = day31.getUniquePathWithObstacle(input);
        System.out.println(output);
    }

    private int getUniquePathWithObstacle(int[][] obstacleGrid) {
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
            System.out.println(Arrays.toString(dp));
        }
        return dp[col - 1];
    }

}