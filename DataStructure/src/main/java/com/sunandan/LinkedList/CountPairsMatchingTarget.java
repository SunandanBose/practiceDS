package com.sunandan.LinkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountPairsMatchingTarget {

    public int countPairs(LinkedList<Integer> head1,
                          LinkedList<Integer> head2,
                          int target) {
        int pair = 0;
        Set<Integer> set = new HashSet();
        for (int head : head1)
            set.add(head);
        for (int head : head2) {
            if (set.contains(target - head))
                pair++;
        }
        return pair;
    }

}
