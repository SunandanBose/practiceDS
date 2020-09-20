package com.sunandan.permutation;

public class RepeatedString {

    public boolean repeatedSubstringPattern(String inputString) {
        int inputStringLength = inputString.length();
        for (int i = inputStringLength / 2; i >= 1; i--) {
            //incase the length of input String is odd. We cannot from a string from the subString.
            if (inputStringLength % i == 0) {
                int numberOfSubstring = inputStringLength / i;
                String subString = inputString.substring(0, i);
                StringBuilder temp = new StringBuilder();
                //create String from the subString
                for (int j = 0; j < numberOfSubstring; j++) {
                    temp.append(subString);
                }

                if (temp.toString().equals(inputString)) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPatternUsingRecursion(String input) {
        if(input.length() % 2 != 0) return false;
        return repeatedSubstringPatternUsingRecursion(input, input.length() / 2);
    }

    private boolean repeatedSubstringPatternUsingRecursion(String actualString, int pivot) {
        if (pivot < 1)
            return false;
        String subString = actualString.substring(0, pivot);
        if(repeat(subString, actualString.length()/pivot).equals(actualString))
            return true;
        return repeatedSubstringPatternUsingRecursion(actualString, pivot-1);
    }

    private String repeat(String input, int numberOfTimes){
        StringBuilder output = new StringBuilder();
        for(int i = 0 ; i<numberOfTimes;i++)
            output.append(input);
        return output.toString();
    }

}
