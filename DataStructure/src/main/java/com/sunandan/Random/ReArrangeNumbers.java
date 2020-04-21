package com.sunandan.Random;

import java.util.Arrays;

/*
        Given an array of numbers, arrange them in a way that yields the largest value.
        For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654
        gives the largest value. And if the given numbers are
        {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
*/
public class ReArrangeNumbers {

    public String getLargestNumber(Integer[] numbers) {
        Arrays.sort(numbers, (a, b) -> {
            int sum1 = getSum(a, b);
            int sum2 = getSum(b, a);
            if(sum1 == sum2)
            return 0;
            else if (sum1 > sum2)
                return 1;
            else
                return -1;
        });
        StringBuffer s = new StringBuffer();
        for(Integer i : numbers){
            s.append(i);
        }
        return s.toString();
    }

    private int getSum(int a, int b){
        return (int)(b*Math.pow(10,String.valueOf(a).length()) + a);
    }

}
