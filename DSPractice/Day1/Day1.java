import java.util.*;
public class Day1{

     public static void main(String []args){
        System.out.println("Hello World");
        int[] input = {1,-2,4,5,1,-8, 11};
        System.out.println(new Day1().findMaxSumOfContinuousSubArray(input));
     }
     
     private int findMaxSumOfContinuousSubArray(int[] arr){
         int maxValue = 0;
         int n = arr.length;
         List<Integer> currlist = new ArrayList<>();
         List<Integer> maxList = new ArrayList<>();
         int currSum = 0;
         for(int i = 0; i < n; i++){
             if(currSum + arr[i] < arr[i]){
                 currSum = 0;
                 currlist = new ArrayList<>();
             }
             currSum += arr[i];
             currlist.add(arr[i]);
             if(maxValue < currSum){
                 maxValue = currSum;
                 maxList = new ArrayList<>();
                 maxList.addAll(currlist);
             }
         }
         System.out.println(maxList);
         return maxValue;
     }
}