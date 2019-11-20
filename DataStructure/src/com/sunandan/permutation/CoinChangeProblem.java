package com.sunandan.permutation;


import java.util.*;
 import java.util.stream.*;

 class CoinChangeProblem{



 	public static void main(String args[]){

 		List<Integer> coinDeminations = Arrays.asList(1,2,3);
 		List<List<Integer>> result = getDenomination(new ArrayList<>(),coinDeminations, 4);
 		result.forEach(i -> {
 			i.forEach(j -> System.out.print(j));
 			System.out.println();
 		});

 	}
  
 	private static List<List<Integer>> getDenomination(List<Integer> resultSet, List<Integer> coinDeminations, int finalCoinAmount){
 		List<List<Integer>> result = new ArrayList<>();  
 		int sum = resultSet.stream().reduce(0, (a, b) -> a + b);
 		
 		if( sum == finalCoinAmount){
 			resultSet.forEach(System.out::print);
 			System.out.println();
 			return result;
 		}
 		for(Integer i : coinDeminations) {
 			sum = resultSet.stream().reduce(0, (a, b) -> a + b);
 			List<Integer> temp = new ArrayList<>(resultSet);
 			if(sum + i <= finalCoinAmount){
 				temp.add(i);
 				getDenomination(temp,coinDeminations,finalCoinAmount);
 			}
 			if(sum == finalCoinAmount) {
 				result.add(temp);
 			}
 		}
 		return result;
 		
 	}

 }