package com;

import java.util.HashSet;
import java.util.Scanner;

public class Perfectpth {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if(str.indexOf('.') != -1) {
			double x = Double.parseDouble(str);
			double newNum;
			int largestP = 1;
			boolean flag=false;
			for (int i = 2; i< 10; i++) {
				for (int j = 1;j < 10; j++) {
					newNum = Math.pow(i, -j);
					if (newNum < x) {
						break;
					}
					if (newNum == x) {
						largestP = j;
						flag=true;
					}
				}
				if(flag==true) {
					System.out.println(largestP);
					return;
				}	
			}
			System.out.println(0);
		}
		else {
			int x =Integer.parseInt(str);
			double newNum;
			int largestP = 1;
			int ilimit = (int)x/2;
			int jlimit = (int) Math.sqrt(x);
			boolean flag=false;
			for (int i = 2; i < ilimit; i++) {
				for (int j = 2; j <= jlimit; j++) {
					newNum = Math.pow(i, j);
					if (newNum > x) {
						break;
					}
					if (newNum == x) {
						largestP = j;
						flag=true;
					}
				}
				if(flag==true) {
					System.out.println(largestP);
					return;
				}	
			}
			System.out.println(1);
		}
	}

}
