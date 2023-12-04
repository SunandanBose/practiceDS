package com.sunandan;

public class TripleStep {

	
	static int[] step ;
		
	public static void main(String[] args) {
		int n=33;
		step = new int[n];
		step[0] = 1;
		step[1] = 2;
		step[2] = 4;
		int possibleWays = countStep(n);
		System.out.println(possibleWays);
	}
	private static int countStep(int n) {
		if(step[n-1]!=0)
			return step[n-1];
		if(n<1)
			return 0;
		if(n<=3)
			return step[n-1];
		else
			step[n-1]=countStep(n-1)+countStep(n-2)+countStep(n-3);
			return step[n-1];
			
	}

}
