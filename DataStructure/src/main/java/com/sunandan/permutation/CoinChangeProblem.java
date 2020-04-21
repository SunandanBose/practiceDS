package com.sunandan.permutation;


import java.util.*;

class CoinChangeProblem {
	public List<List<Integer>> getDenomination(List<Integer> coinDenominations, int finalCoinAmount) {
		List<List<Integer>> resultList = new ArrayList<>();
		for (Integer i : coinDenominations) {
			List<Integer> resultSet = new ArrayList<>();
			resultSet.add(i);
			List<Integer> denominations = getDenomination(coinDenominations, finalCoinAmount - i, resultSet);
			resultList.add(denominations);
		}
		return resultList;
	}

	// [1,2,3] - 3, [1]
	private List<Integer> getDenomination(List<Integer> coinDenominations, int finalCoinAmount, List<Integer> resultSet) {
		if(finalCoinAmount == 0){
			return resultSet;
		}
		for (Integer i : coinDenominations) {
			int sum = resultSet.stream().reduce(0, (a, b) -> a + b);
			if(sum + i <= finalCoinAmount){
				resultSet.add(i);
				getDenomination(coinDenominations, finalCoinAmount - i, resultSet);
			}
		}
		return resultSet;
	}
}