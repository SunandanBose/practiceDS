package com.sunandan.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

    public int palindromeByMinPartitionCut(String input) {
        char[] characters = input.toCharArray();
        int[] minPartitionRequired = new int[input.length()];
        //minPartitionRequired : stores the min partition required upto that character to form palindrome
        boolean[][] inputPalindromeMatrix = new boolean[input.length()][input.length()];
        //inputPalindromeMatrix : stores whether the input string from row value to column value is palindrome or not

        for (int i = 0; i < input.length(); i++) {
            //i loop  : iterates each character from the input string
            int min = i; // min value for character is set to i by default considering the worst case
            //that none of the substring from 0 to i form a palindrome.
            for (int j = 0; j <= i; j++) {
                if (characters[i] == characters[j] && (j + 1 > i - 1 || inputPalindromeMatrix[j + 1][i - 1])) {
                    //compare characters at i and j place because in palindrome both the extreme characters are same
                    // j+1>i-1 to check if the character is same or adjacent
                    //inputPalindromeMatrix[j+1][i-1] this will be executed if both the extreme characters are same
                    //and i and j is not referring to the same or adjacent character i.e the string between j to i can be a palindrome
                    //so we use dp to check if the string between j+1 to i-1 can be a palindrome
                    inputPalindromeMatrix[j][i] = true;
                    if (j == 0)//first element and last element matches then entire string from i to j is palindrome
                        min = 0;
                    else
                        min = Math.min(min, minPartitionRequired[j - 1] + 1);
                }
            }
            minPartitionRequired[i] = min;
        }
        return minPartitionRequired[input.length() - 1];
    }


    // better solution
    public int minCut(String s) {
        List<Integer> result = new ArrayList<Integer>();
        if(s.length() == 1) return 0;
        if(isPalindrome(s)) return 0;
        for(int i = 1; i < s.length(); i++)    {
            int l = minCut(s.substring(0,i));
            int r = minCut(s.substring(i));
            result.add(l + 1 + r);
        }
        return result.stream().reduce((x, y) -> x.compareTo(y) <= 0  ? x : y).get();
        //return result.stream().min(Integer::valueOf).get();

    }

    private boolean isPalindrome(String input){
        for(int i = 0; i< (input.length()/2); i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i))
                return false;
        }
        return true;
    }

    //If you still fail to recall the logic follow the video
    //https://www.youtube.com/watch?v=WPr1jDh3bUQ
}
