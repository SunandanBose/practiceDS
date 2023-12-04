package com.sunandan.permutation;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s{2,}", " ");
        String[] sentence = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sentence.length - 1; i > 0; i--) {
            sb.append(sentence[i]);
            sb.append(" ");
        }
        sb.append(sentence[0]);
        return sb.toString();
    }

}
