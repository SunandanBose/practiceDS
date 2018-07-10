package com.sunandan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<Integer> values = (Arrays.asList(7,8,9,3,5,6,1));
		Map<Boolean, List<Integer>> collect = values.stream().sorted()
				.collect(Collectors.groupingBy(i -> i%2==0 ));
		List<Integer> mergedList = mergeList(collect.get(true),collect.get(false));
		mergedList.forEach(System.out::println);
	}

	private static List<Integer> mergeList(List<Integer> list_1, List<Integer> list_2) {
		int c1 = 0, c2 = 0;
	    List<Integer> mergedList = new ArrayList<Integer>();
	    while(c1 < list_1.size() || c2 < list_2.size()) {
	    	if(c2 < list_2.size())
	        	mergedList.add((Integer) list_2.get(c2++));
	    	if(c1 < list_1.size())
	        	mergedList.add((Integer) list_1.get(c1++));
	    }
	    return mergedList;
	}

}
