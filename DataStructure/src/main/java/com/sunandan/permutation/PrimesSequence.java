package com.sunandan.permutation;

import java.util.*;

public class PrimesSequence {

    public static void main(String[] args) {
        PrimesSequence ps = new PrimesSequence();
        System.out.println(ps.getSmallestIntegerForGivenPrimeNumber(Arrays.asList(3, 113, 1249), 6));
    }

    public List<Integer> getSmallestIntegerForGivenPrimeNumber(List<Integer> primeNumbers, int NoOfValuesToFind) {
        List<Integer> smallestIntegerList = new ArrayList<>();
        TreeSet<Integer> tempSet = new TreeSet<>();
        tempSet.add(1);
        while (tempSet.size() != 0) {
            if (smallestIntegerList.size() >= NoOfValuesToFind) break;
            int x = tempSet.pollFirst();
            if (x != 1)
                smallestIntegerList.add(x);
            for (int i = 0; i < 3; i++)
                tempSet.add(x * primeNumbers.get(i));
        }
        return smallestIntegerList;
    }
}
