package com.sunandan.google;

public class RegexExp {

    public boolean isMatch(String toMatch, String pattern){
        if(pattern.length() == 0) return  toMatch.isEmpty();
        boolean firstMatch = (!(toMatch.length() == 0) && (pattern.charAt(0) == toMatch.charAt(0) || pattern.charAt(0) == '.'));
        if(pattern.length() >= 2 && pattern.charAt(1) == '*')
            return isMatch(toMatch,pattern.substring(2)) || (firstMatch && isMatch(toMatch.substring(1),pattern));
        else
            return firstMatch && isMatch(toMatch.substring(1),pattern.substring(1));
    }
}
