package com.sunandan.permutation;


import java.util.*;
 import java.util.stream.*;

 class CoinChangeProblem{


  
 	public void getDenomination(List<Integer> resultSet, List<Integer> coinDeminations, int finalCoinAmount){
 		int sum = resultSet.stream().reduce(0, (a, b) -> a + b);
 		if( sum == finalCoinAmount){
 			resultSet.forEach(System.out::print);
 			System.out.println();
 			return;
 		}
 		for(Integer i : coinDeminations) {
 			sum = resultSet.stream().reduce(0, (a, b) -> a + b);
 			List<Integer> temp = new ArrayList<>(resultSet);
 			if(sum + i <= finalCoinAmount){
 				temp.add(i);
 				getDenomination(temp,coinDeminations,finalCoinAmount);
 			}
 		}
 		return;
 	}

 }