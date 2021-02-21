import java.util.*;

/**
 * Day26
 */
public class Day26 {
    public static void main(String[] args) {
        Day26 day26 = new Day26();
        System.out.println(day26.longestIncreasingSubsequence(Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60, 80)));
        System.out.println(day26.longestIncreasingSubsequenceDP(Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60, 80)));
    }

    private int longestIncreasingSubsequenceDP(List<Integer> list) {
        int[] dp = new int[list.size()];
        return longestIncreasingSubsequenceDP(list, dp);
    }

    private int longestIncreasingSubsequenceDP(List<Integer> list, int[] dp) {
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < list.size(); i++) {
            int len = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j)) {
                    len = Math.max(len, dp[j]);
                }
            }
            dp[i] = len + 1;
            max = Math.max(len + 1, max);
        }
        return max;
    }

    private int longestIncreasingSubsequence(List<Integer> input) {
        return longestIncreasingSubsequence(input, Integer.MIN_VALUE, 0);
    }

    private int longestIncreasingSubsequence(List<Integer> input, int prev, int curr) {
        if (curr >= input.size())
            return 0;
        int count1 = 0, count2 = 0;
        if (input.get(curr) > prev)
            count1 = 1 + longestIncreasingSubsequence(input, input.get(curr), curr + 1);
        count2 = longestIncreasingSubsequence(input, prev, curr + 1);
        return Math.max(count1, count2);
    }
}