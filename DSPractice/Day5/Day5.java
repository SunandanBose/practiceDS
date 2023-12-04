import java.util.*;
import java.util.stream.*;

public class Day5 {

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        final long startTime = System.currentTimeMillis();
        System.out.println(day5.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(day5.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(day5.isInterleave("aa", "ab", "abaa"));
        System.out.println(day5.isInterleave("cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc",
        "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb",
        "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (cache.get(s1 + "|" + s2 + "|" + s3) != null)
            return cache.get(s1 + "|" + s2 + "|" + s3);
        boolean string1Result = false;
        boolean string2Result = false;
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        if (s1.charAt(0) == s3.charAt(0)) {
            int index = 1;
            string1Result = isInterleave(s1.substring(index), s2, s3.substring(index));
        }
        if (s2.charAt(0) == s3.charAt(0)) {
            int index = 1;
            string2Result = isInterleave(s1, s2.substring(index), s3.substring(index));
        }
        cache.put(s1 + "|" + s2 + "|" + s3, string1Result || string2Result);
        return string1Result || string2Result ? true : false;
    }

    private int minJump(int[] arr) {
        int jump = 0;
        int currFarthest = 0;
        int currEnd = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            currFarthest = Math.max(arr[i] + i, currFarthest);
            if (i == currEnd) {
                currEnd = currFarthest;
                jump++;
            }
        }
        return jump;
    }

    private Integer[] maxContinuousSubArray(int[] arr) {
        List<Integer> currList = new ArrayList<>();
        List<Integer> maxArrayList = new ArrayList<>();
        int currValue = 0;
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currValue + arr[i] < arr[i]) {
                currList = new ArrayList<>();
                currValue = 0;
            }
            currValue += arr[i];
            currList.add(arr[i]);
            if (currValue > maxValue) {
                maxArrayList = new ArrayList<>();
                maxValue = currValue;
                maxArrayList.addAll(currList);
            }
        }
        return maxArrayList.toArray(new Integer[maxArrayList.size()]);
    }

    private int minCutPalindromePartitioning(String s) {
        List<Integer> result = new ArrayList<>();
        if (isPalindrome(s))
            return 0;
        for (int i = 1; i < s.length(); i++) {
            int l = minCutPalindromePartitioning(s.substring(0, i));
            int r = minCutPalindromePartitioning(s.substring(i));
            result.add(l + 1 + r);
        }
        return result.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    private boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        if (wordDict.contains(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)) {
                return true;
            }
        }
        return false;
    }

}