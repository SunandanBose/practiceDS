package com.sunandan.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation
{
	static List<String> permutationString = new ArrayList<>();
	
    public static void main(String[] args)
    {
    	
    	String str = "ABC";
        new Permutation().permute(str, 0, str.length()-1);
        System.out.println(permutationString.size());
        permutationString.forEach(System.out::println);
        
    }
    private void permute(String str, int initial, int last)
    {
        if(initial == 0 && last ==0) { 
        	permutationString.add(str);
        	permute(str,initial+1,str.length()-1);
        }
    	if(initial==last)
        	return;
        permute(str,initial,last-1);
        if(str.charAt(initial) != str.charAt(last)){
            str = swap(str,initial,last);
            if(!permutationString.contains(str))
                permutationString.add(str);
        }
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
