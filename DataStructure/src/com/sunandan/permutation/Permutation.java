package com.sunandan.permutation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Permutation {

	static Queue<String> queueList = new LinkedList<String>();
	public static void main(String[] args) {
		String str = "ABC";
		queueList.add(Character.toString(str.charAt(0)));
		permute(str);
		queueList.stream().collect(Collectors.toSet()).forEach(System.out::println);
	}
	private static void permute(String str) {
		while(true){
			if(queueList.peek().length() ==  str.length())
				return;
			getPermutationsOfString(str,queueList.peek(),0);
			queueList.remove();
		}
	}
	private static void getPermutationsOfString(String str, String newstr, int index) {
		if(index > newstr.length()) return;
		queueList.add(new StringBuffer().append(newstr).insert(index, str.charAt(newstr.length())).toString());
		getPermutationsOfString(str,newstr,index += 1);
	}
}
