import java.util.*;

/**
 * Day18
 */
public class Day18 {

    int[] xdir = { 0, 1, 0, -1 };
    int[] ydir = { -1, 0, 1, 0 };

    public static void main(String[] args) {
        Day18 day18 = new Day18();
        System.out.println(day18.calculate("3*2+20-10"));
        System.out.println(day18.longestCommonSequence("abcde", "ace"));
        int[] height = { 4, 2, 0, 3, 2, 5 };
        System.out.println(day18.trappingRainWater(height));
        int[][] grid = { { 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 1 } };
        System.out.println(day18.isLandProblemCountClusters(grid));
    }

    private int isLandProblemCountClusters(int[][] grid) {
        int countClusters = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    countClusters++;
                    for (int dir = 0; dir < 4; dir++) {
                        visited = markNeighboursAsVisited(grid, visited, i + xdir[dir], j + ydir[dir]);
                    }
                }
            }

        }
        return countClusters;
    }

    private boolean[][] markNeighboursAsVisited(int[][] grid, boolean[][] visited, int row, int col) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1
                && !visited[row][col]) {
            visited[row][col] = true;
            for (int dir = 0; dir < 4; dir++) {
                visited = markNeighboursAsVisited(grid, visited, row + xdir[dir], col + ydir[dir]);
            }
        }
        return visited;
    }

    private int trappingRainWater(int[] height) {
        int result = 0;
        int totalLength = height.length;
        int[] leftMax = new int[totalLength];
        int[] rightMax = new int[totalLength];
        leftMax[0] = height[0];
        rightMax[totalLength - 1] = height[totalLength - 1];
        for (int i = 1; i < totalLength; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = totalLength - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < totalLength; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }

    private int longestCommonSequence(String str1, String str2) {
        int totalLength1 = str1.length();
        int totalLength2 = str2.length();
        int[][] dp = new int[totalLength1 + 1][totalLength2 + 1];
        for (int i = 0; i < totalLength1; i++) {
            for (int j = 0; j < totalLength2; j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[totalLength1][totalLength2];
    }

    private int calculate(String input) {
        int result = 0;
        int totalLength = input.length();
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        for (int i = 0; i < totalLength; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch))
                num = num * 10 + ch - '0';
            if ((!Character.isDigit(ch) && ch != ' ') || i == totalLength - 1) {
                if (operator == '-')
                    stack.push(-num);
                if (operator == '+')
                    stack.push(num);
                if (operator == '*')
                    stack.push(stack.pop() * num);
                if (operator == '/')
                    stack.push(stack.pop() / num);
                operator = ch;
                num = 0;
            }
        }
        result = stack.stream().reduce(0, (a, b) -> a + b);
        return result;
    }
}