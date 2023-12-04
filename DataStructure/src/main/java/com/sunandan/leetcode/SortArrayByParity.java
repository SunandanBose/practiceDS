package com.sunandan.leetcode;

import java.util.LinkedList;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0) return null;
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (A[i] % 2 == 0)
                linkedList.addFirst(A[i]);
            else
                linkedList.addLast(A[i]);
        }
        return linkedList.stream().mapToInt(i -> i).toArray();
    }

}
