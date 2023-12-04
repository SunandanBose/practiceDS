package com.sunandan.google;

public class InterLeaveString {

    public boolean interLeaveString(String s1, String s2, String s3){
        boolean str1BooleanValue = false;
        boolean str2BooleanValue = false;
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        if(s1.length() == 0)
            return s2.length() > 0 && s2.equals(s3);
        if(s2.length() == 0)
            return s1.length() > 0 && s1.equals(s3);
        if(s1.charAt(0) == s3.charAt(0))
            str1BooleanValue = interLeaveString(s1.substring(1),s2,s3.substring(1));
        if(s2.charAt(0) == s3.charAt(0))
            str2BooleanValue =  interLeaveString(s1,s2.substring(1),s3.substring(1));
        return str1BooleanValue || str2BooleanValue ? true : false;
    }

}
