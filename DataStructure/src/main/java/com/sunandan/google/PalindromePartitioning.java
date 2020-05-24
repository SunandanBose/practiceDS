package com.sunandan.google;

import java.util.Arrays;

public class PalindromePartitioning {

    public int palindromeByMinCut(String input) {
        char[] characters = input.toCharArray();
        int[] minPartitionRequired = new int[input.length()];
        //minPartitionRequired : stores the min partition required upto that character to form palindrome
        boolean[][] inputPalindromeMatrix = new boolean[input.length()][input.length()];
        //inputPalindromeMatrix : stores whether the input string from row value to column value is palindrome or not

        for(int i = 0;i<input.length();i++){
            //i loop  : iterates each character from the input string
            int min = i; // min value for character is set to i by default considering the worst case
            //that none of the substring from 0 to i form a palindrome.
            for(int j=0;j<=i;j++){
                if(characters[i] == characters[j] && ( j+1>i-1 || inputPalindromeMatrix[j+1][i-1])){
                    //compare characters at i and j place because in palindrome both the extreme characters are same
                    // j+1>i-1 to check if the character is same or adjacent
                    //inputPalindromeMatrix[j+1][i-1] this will be executed if both the extreme characters are same
                    //and i and j is not referring to the same or adjacent character i.e the string between j to i can be a palindrome
                    //so we use dp to check if the string between j+1 to i-1 can be a palindrome
                    inputPalindromeMatrix[j][i] = true;
                    if(j == 0)//first element and last element matches then entire string from i to j is palindrome
                        min = 0;
                    else
                        min = Math.min(min,minPartitionRequired[j-1]+1);
                }
            }
            minPartitionRequired[i] = min;
        }
        return minPartitionRequired[input.length()-1];
    }

    //If you still fail to recall the logic follow the video
    //https://www.youtube.com/watch?v=WPr1jDh3bUQ
}
