package com.sunandan.recursiveMultiply;

public class RecursiveMultiply {

	public static void main(String[] args) {
		int n1 = 1;
		int n2 = -46;
		int product = recurMultiply(n1, n2);
		System.out.println(product);
	}

	private static int recurMultiply(int x, int y) {
		if(y==0)
			return 0;
		else if(y<0)
			return (-x+recurMultiply(x,y+1));
		else
			return (x+recurMultiply(x,y-1));
	}

}
