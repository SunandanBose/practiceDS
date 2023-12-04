import java.util.*;
import java.util.stream.*;

public class Day4 {

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("word break1 : " + day4.wordBreak("leetcode", wordDict));
        wordDict = Arrays.asList("apple", "pen");
        System.out.println("word break2 : " + day4.wordBreak("applepenapple", wordDict));
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("word break3 : " + day4.wordBreak("catsandog", wordDict));
        int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("kadane algorithm : " + Arrays.toString(day4.maxContinuousSubArray(input)));
        int[] arr = { 2, 3, 1, 1, 4 };
        System.out.println("min jump : " + day4.minJump(arr));
        System.out.println("min palindrome partitioning : "+ day4.minPartition("AAB"));
    }

    private boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict))
                return true;
        }
        return false;
    }

    private Integer[] maxContinuousSubArray(int[] arr) {
        List<Integer> currList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        int currValue = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (currValue + arr[i] < arr[i]) {
                currValue = 0;
                currList = new ArrayList<>();
            }
            currValue += arr[i];
            currList.add(arr[i]);
            if (maxValue < currValue) {
                maxList = new ArrayList<>();
                maxValue = currValue;
                maxList.addAll(currList);
            }
        }
        return maxList.toArray(new Integer[maxList.size()]);
    }

    private int minJump(int[] arr) {
        int currEnd = 0;
        int currFarthest = 0;
        int jump = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            currFarthest = Math.max(currFarthest, arr[i] + i);
            if (currEnd == i) {
                currEnd = currFarthest;
                jump++;
            }
        }
        return jump;
    }

    private int minPartition(String s){
        List<Integer> result = new ArrayList<>();
        if(isPalindrome(s))
            return 0;
        for (int i = 1; i < s.length(); i++) {
            int l = minPartition(s.substring(0, i));
            int r = minPartition(s.substring(i));
            result.add(l + r + 1);
        }
        return result.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    private boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }

}