import java.util.*;

/**
 * Day16
 */
public class Day16 {
    public static void main(String[] args) {
        Day16 day16 = new Day16();
        System.out.println(day16.calculate("1+1*3"));
        System.out.println(day16.longestCommonSubsequence("abcde", "ace"));
    }

    private int longestCommonSubsequence(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if(str1.charAt(i) == str2.charAt(j))
                    dp[i+1][j+1] = dp[i][j]+1;
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
            
        }
        return dp[length1][length2];
    }

    private int calculate(String input) {
        int result = 0;
        if (input == null || input.length() == 0)
            return result;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (int) (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == input.length() - 1) {
                if (sign == '-')
                    stack.push(-num);
                if (sign == '+')
                    stack.push(num);
                if (sign == '*')
                    stack.push(stack.pop() * num);
                if (sign == '/')
                    stack.push(stack.pop() / num);
                sign = ch;
                num = 0;
            }
        }
        result = stack.stream().reduce(0, (a, b) -> a + b);
        return result;
    }
}