import java.util.*;

/**
 * Day17
 */
public class Day17 {

    public static void main(String[] args) {
        Day17 day17 = new Day17();
        System.out.println(day17.calculate("2*4+3/3-1"));
        System.out.println(day17.longestCommonSubsequence("abcde", "ace"));
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(day17.trappingRainWatter(height));
        int[] height1 = { 4, 2, 0, 3, 2, 5 };
        System.out.println(day17.trappingRainWatter(height1));
    }

    private int trappingRainWatter(int[] height) {
        int totalLength = height.length;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int result = 0;
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
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

    private int longestCommonSubsequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[length1][length2];
    }

    private int calculate(String input) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == input.length() - 1) {
                if (operation == '-')
                    stack.push(-num);
                if (operation == '+')
                    stack.push(num);
                if (operation == '*')
                    stack.push(stack.pop() * num);
                if (operation == '/')
                    stack.push(stack.pop() / num);
                num = 0;
                operation = ch;
            }
        }
        result = stack.stream().reduce(0, (a, b) -> a + b);
        return result;
    }

}