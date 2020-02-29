package com.sunandan.permutation;

import java.util.*;

class WordBreak{

	public static void main(String args[]){
		String[] dictionary = { "i","like","love","and","sam","sung","samsung","mobile","ice","cream","icecream","man","go","mango"};
		String unBrokenString = "ilikesamsungmobile";
		wordBreak(unBrokenString,dictionary);
		unBrokenString = "iloveicecreamandmango";
        wordBreak(unBrokenString,dictionary);

	}

	static Stack<String> stack = new Stack();

	private static void wordBreak(String inputString,String[] dictionary){
		if(inputString.equals("")){
			print(stack);
			System.out.println();
		}
		for(String str : dictionary){
			if(inputString.startsWith(str)){
				stack.push(str);
				wordBreak(inputString.replaceFirst(str,""),dictionary);
				stack.pop();
			}
		}
	}

	private static void print(Stack<String> stack){
		for(String str : stack)
			System.out.print(str + " ");
	}

}
