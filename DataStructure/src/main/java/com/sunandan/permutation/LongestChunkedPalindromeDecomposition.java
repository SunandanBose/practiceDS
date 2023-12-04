package com.sunandan.permutation;

public class LongestChunkedPalindromeDecomposition {

    public int longestDecomposition(String text) {
        int totalLength = text.length();
        for(int index = 1; index <= totalLength/2; index++){
            String firstPart = text.substring(0,index);
            String lastPart = text.substring(totalLength - index);
            if(firstPart.equals(lastPart)){
                return 2 + longestDecomposition(remove(text, index));
            }
        }
        return totalLength == 0 ? 0 : 1;
    }

    private String remove(String input, int indexToCut) {
        return input.substring(indexToCut, input.length()-indexToCut);
    }


}
