package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


public class MaxBirthday{

	public static void main(String args[]){
		List<List<Integer>> choices = new ArrayList<>();
		List<Integer> choice1= new ArrayList<>();
		List<Integer> choice2= new ArrayList<>();
		List<Integer> choice3= new ArrayList<>();
		choice1.add(1);
		choice1.add(2);
		choice1.add(3);
		choices.add(choice1);
		choice2.add(2);
		choices.add(choice2);
		choice3.add(3);
		choices.add(choice3);
		System.out.println(choices);
		System.out.println(chidrenSatisfied(2,2,3,choices));
	}

	private static int chidrenSatisfied(int row, int column, int noOfChildren, List<List<Integer>> choices){
		Map<Integer,List<List<Integer>>> quantityChoiceMap = new HashMap<>();
		List<List<Integer>> temp ;
		Map<Integer,String> cakeAvailability = new HashMap<>();
		int satisfactionCounter = 0;
		for(int i=0;i<noOfChildren;i++){
			temp = new ArrayList<>();
			if(quantityChoiceMap.get(choices.get(i).size()) != null){
				temp =  quantityChoiceMap.get(choices.get(i).size());
			}
			temp.add(choices.get(i));
			quantityChoiceMap.put(choices.get(i).size(),temp);
			System.out.println(quantityChoiceMap);
		}
		for(int i=1;i<=noOfChildren;i++){
			if(quantityChoiceMap.containsKey(i)){
				temp = new ArrayList<>();
				temp = quantityChoiceMap.get(i);
				//System.out.println(i + " "+temp);
				for(int j=0;j<temp.size();j++){
					for(int k=0;k<temp.get(j).size();k++){
						if(!cakeAvailability.containsKey(temp.get(j).get(k))){
							cakeAvailability.put(temp.get(j).get(k), "NotAvailable");
							satisfactionCounter++;
						}
					}
				}
			}
		}

		return satisfactionCounter;

	}
}