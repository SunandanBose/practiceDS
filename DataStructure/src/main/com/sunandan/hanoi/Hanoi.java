package com.sunandan.hanoi;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Hanoi {
	public static void main(String[] args) {
		Stack<Integer> stack_1 = new Stack<>();
		Stack<Integer> stack_2 = new Stack<>();
		Stack<Integer> stack_3 = new Stack<>();
		for(int i=5;i>0;i--) {
			stack_1.push(i);
		}
		List<Stack<Integer>> stackList =Arrays.asList(stack_1,stack_2,stack_3);
		System.out.println(recursiveApproach(4));
		
		int indx = 0,count = 0;
		while(true) {
			if(stack_1.isEmpty() && stack_2.isEmpty()) {
				System.out.println("Hanoi complete!!! Number of steps Taken : " +count);
				stack_3.forEach(i -> System.out.println(i));
				return;
			}
			if(stackList.get(indx%3).isEmpty()) {
				indx++;
				continue;
			}
			if(stackList.get((indx+1)%3).isEmpty() || (stackList.get(indx%3).peek()< stackList.get((indx+1)%3).peek()) ) {
				stackList.get((indx+1)%3).push(stackList.get(indx%3).pop());
				indx += 2;
				count++;
				continue;
			}
			if(stackList.get((indx+2)%3).isEmpty() || (stackList.get(indx%3).peek()< stackList.get((indx+2)%3).peek()) ) {
				stackList.get((indx+2)%3).push(stackList.get(indx%3).pop());
				indx += 3;
				count++;
				continue;
			}
			indx++;
		}
		

	}
/*
	private static void display(Stack<Integer> stack) {
		stack.forEach(i -> System.out.println(i));
	}*/

	private static int recursiveApproach(int n) {
		if((n==0)||(n==1))
			return n;
		else 
			return (recursiveApproach(n-1)*2)+1;
		
		
	}

}
