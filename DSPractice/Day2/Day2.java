import java.util.*;

public class Day2{

	public static void main(String[] args) {
		Day2 day2 = new Day2();
		int[] input = {2,3,1,1,4};
		System.out.println(day2.minJump(input));
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(Arrays.toString(day2.maxContinuousSubArray(arr)));
	}

	private Integer[] maxContinuousSubArray(int[] arr){
		List<Integer> maxList = new ArrayList<>();
		List<Integer> currList = new ArrayList<>();
		int maxValue = 0, currSum = 0;
		for(int i = 0; i < arr.length; i++){
			if(currSum + arr[i] < arr[i]){
				currSum = 0;
				currList = new ArrayList<>(); 
			}
			currSum += arr[i];
			currList.add(arr[i]);
			if(maxValue < currSum){
				maxValue = currSum;
				maxList = new ArrayList<>();
				maxList.addAll(currList);
			}
		}
		return maxList.toArray(new Integer[maxList.size()]);
	}

	private int minJump(int[] input){
	    int jump = 0;
	    int currEnd = 0;
	    int currFarthest = 0;
	    for(int i = 0; i < input.length-1; i++){
	        currFarthest = Math.max(currFarthest,(input[i] + i));
	        if(currEnd == i){
	            jump++;
	            currEnd = currFarthest;
	        }
	    }
	    return jump;
	}

}