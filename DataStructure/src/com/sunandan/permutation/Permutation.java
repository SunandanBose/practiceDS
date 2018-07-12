package com.sunandan.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation
{
	static Set<String> permutationString = new HashSet<>();
	
    public static void main(String[] args)
    {
    	
    	String str = "ABC";
        new Permutation().permute(str, 0, str.length()-1);
        permutationString.forEach(System.out::println);
        
    }
    private void permute(String str, int initial, int last)
    {
        if(initial>last)
        	return;
        permute(str,initial,last-1);
        str = swap(str,initial,last);
        permutationString.add(str);
        permute(str,initial+1,str.length()-1);
    }

    public String swap(String a, int i, int j)
    {
    	if(i==j)
    		return a;
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
 
}