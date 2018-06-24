package com.sunandan;

public class TripleStep {

	
	static int step[] = {1,2,4} ;
	public static void main(String[] args) {
		int n=5;
		int possibleWays = countStep(n);
		System.out.println(possibleWays);
	}
	private static int countStep(int n) {
		if(n<1)
			return 0;
		if(n<=3)
			return step[n-1];
		else
			return countStep(n-1)+countStep(n-2)+countStep(n-3);
			
	}

}
