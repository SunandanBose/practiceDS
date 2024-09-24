import java.util.*;
// https://leetcode.com/problems/different-ways-to-add-parentheses/?envType=daily-question&envId=2024-09-23
class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if (expression == null || expression.trim().equals(""))
            return res;
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (ch == '+') res.add(a + b);
                        else if (ch == '-') res.add(a - b);
                        else if (ch == '*') res.add(a * b);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}
