package com.sunandan;

import java.util.*;


/*
Sherlock and Cost

Array A contains the elements, A1,A2...An. And array B contains the elements, B1,B2...Bn. 
There is a relationship between Ai and Bi, where 1 ≤ i ≤ n, i.e., 
any element Ai lies between 1 and Bi.
Let the cost S of an array A be defined as:


S = |Ai - Ai-1| where i travels from 2 to n
n is the length of array B

*/


class SherlockCost{
	private int cost(int[] array) {
        int replacing_with_one = 0,max = 0,max_value_on_replacing_with_one = 0;
        for (int i = 1; i < array.length; i++) {
            max_value_on_replacing_with_one = Math.max(replacing_with_one, max + Math.abs(array[i - 1] - 1));
            max = Math.max(replacing_with_one + Math.abs(array[i] - 1), max + Math.abs(array[i] - array[i - 1]));
            replacing_with_one = max_value_on_replacing_with_one;
        }
        return Math.max(max, replacing_with_one);
    }

    public static void main(String args[]){
    	int[] input_array = new int[]{1,10,20,1,4,5,1};
    	int cost=new SherlockCost().cost(input_array);
    	System.out.println("Sherlock Cost : "+cost);
    }
}