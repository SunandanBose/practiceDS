import java.util.*;
import java.util.stream.Stream;

public class Day3{

	public static void main(String[] args) {
		Day3 day3 = new Day3();
		String str = "AAB";
		System.out.println("Palindrome Partioning : " + day3.minPalindromePartitioning(str));
		int[] input = {2,3,1,1,4};
		System.out.println("Min Jump : " + day3.minJump(input));
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max Sub Array : " + Arrays.toString(day3.maxSubArray(arr)));
	}

	private int minPalindromePartitioning(String str){
		List<Integer> result = new ArrayList<Integer>();
		if(isPalindrome(str))
			return 0;
		for(int i = 1; i < str.length()-1; i++){
			int l = minPalindromePartitioning(str.substring(0,i));
			int r = minPalindromePartitioning(str.substring(i));
			result.add(l + 1 + r);
		}
		return result.stream().min(Comparator.naturalOrder()).orElse(0);
	}

	private boolean isPalindrome(String input){
		int n = input.length();
        for(int i = 0; i < n/2; i++){
        	if(input.charAt(i) != input.charAt(n-i-1))
        		return false;
        }
		return true;
	}

	private int minJump(int[] arr){
		int jump = 0;
		int currEnd = 0;
		int currFarthest = 0;
		for(int i = 0; i<arr.length-1; i++){
			currFarthest = Math.max(currFarthest, arr[i]+i);
			if(i == currEnd){
				currEnd = currFarthest;
				jump ++;
			}
		}
		return jump;
	}

	private Integer[] maxSubArray(int[] input){
		List<Integer> currArrayList = new ArrayList<>();
		List<Integer> maxArrayList = new ArrayList<>();
		int currSum = 0;
		int maxSum = 0;
		for(int i = 0; i < input.length; i++){
			if(input[i] + currSum < input[i]){
				currArrayList = new ArrayList<>();
				currSum = 0;
			}
			currArrayList.add(input[i]);
			currSum += input[i];
			if(currSum > maxSum){
				maxSum = currSum;
				maxArrayList = new ArrayList<>();
				maxArrayList.addAll(currArrayList);
			}
		}
		return maxArrayList.toArray(new Integer[maxArrayList.size()]);
	}

}