package com.sunandan;

import java.lang.*;

/*Find the largest Sum of numbers by skipping one or more numbers in between two addends*/

public class UniqueSum{

     public static void main(String []args){
        int[] numbers = {1,2,5,7,3,8,9};
        System.out.println(
            new UniqueSum().getSumOfAdjacentNumbers
            (numbers, numbers.length-1));
     }
     private int getSumOfAdjacentNumbers(int[] numbers, int indx){
         if(indx == 0) return numbers[0];
         if(indx == 1) return Math.max(numbers[0], numbers[1]);
         return Math.max(getSumOfAdjacentNumbers(numbers,indx -1),
                        numbers[indx] + getSumOfAdjacentNumbers(numbers,indx -2));
     }
     
}
