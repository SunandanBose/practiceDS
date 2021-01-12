
/**
 * Day6
 */
import java.util.*;
import java.util.stream.*;

public class Day6 {

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        System.out
                .println("expected value = false Actual Value : " + day6.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println("expected value = true Actual Value : " + day6.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println("expected value = true Actual Value : " + day6.isInterleave("aa", "ab", "abaa"));
        System.out.println("expected value = true Actual Value : " + day6.isInterleave(
                "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc",
                "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb",
                "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"));
        char[][] input = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println("expected value = 6 Actual Value : " + day6.maximalRectangle(input));
    }

    Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        String key = s1 + " | " + s2 + " | " + s3;
        if (cache.get(key) != null)
            return cache.get(key);
        if (s1.length() == 0)
            return s2.length() > 0 && s2.equals(s3);
        if (s2.length() == 0)
            return s1.length() > 0 && s1.equals(s3);
        Boolean string1MatchResult = false;
        Boolean string2MatchResult = false;
        if (s1.length() > 0 && s3.length() > 0 && s1.charAt(0) == s3.charAt(0))
            string1MatchResult = isInterleave(s1.substring(1), s2, s3.substring(1));
        if (s2.length() > 0 && s3.length() > 0 && s2.charAt(0) == s3.charAt(0))
            string2MatchResult = isInterleave(s1, s2.substring(1), s3.substring(1));
        cache.put(key, string1MatchResult || string2MatchResult);
        return string1MatchResult || string2MatchResult;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        Integer[] result = new Integer[matrix[0].length];
        Arrays.fill(result, 0);
        int maxValue = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = Integer.valueOf(matrix[i][j]) - 48;
                result[j] += value;
                if (value == 0)
                    result[j] = 0;
            }
            maxValue = Math.max(maxValue, getMaxValue(result));
        }
        return maxValue;
    }

    private int getMaxValue(Integer[] input) {
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        List<Integer> uniqueValues = Arrays.stream(input).filter((x) -> x != 0).distinct()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < uniqueValues.size(); i++) {
            sum = 0;
            for (int j = 0; j < input.length; j++) {
                sum += uniqueValues.get(i);
                if (input[j] < uniqueValues.get(i))
                    sum = 0;
                if (maxValue < sum)
                    maxValue = sum;
            }
        }
        return maxValue;
    }

    private int minJump(int[] arr){
        int currEnd = 0;
        int currFarthest = 0;
        int jump = 0;
        for (int i = 0; i < arr.length-1; i++) {
            currFarthest = Math.max(currFarthest, arr[i]+i);
            if(i == currEnd){
                jump++;
                currEnd = currFarthest;
            }
        }
        return jump;
    }

    private boolean wordBreak(String s, List<String> wordDict){
        if(wordDict.contains(s))
            return true;
        for (int i = 1; i < s.length()-1; i++) {
            if(wordDict.contains(s.substring(0,i)) && wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }

    private int minCutPalindromePartitioning(String s){
        if(s == null || s.length() == 0) return 0;
        List<Integer> result = new ArrayList<>();
        if(isPalindrome(s))
            return 0;
        for (int i = 1; i < s.length(); i++) {
            int l = minCutPalindromePartitioning(s.substring(0, i));
            int r = minCutPalindromePartitioning(s.substring(i));
            result.add(l+1+r);
        }
        return result.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    private boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    private Integer[] maxSubArray(int[] arr){
        List<Integer> currList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        int currValue = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] + currValue < arr[i]){
                currList = new ArrayList<>();
                currValue = 0;
            }
            currValue += arr[i];
            currList.add(arr[i]);
            if(maxValue < currValue){
                maxList = new ArrayList<>();
                maxList.addAll(currList);
                maxValue = currValue;
            }
        }
        return maxList.toArray(new Integer[maxList.size()]);
    }
}
