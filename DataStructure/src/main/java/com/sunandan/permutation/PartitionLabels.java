package com.sunandan.permutation;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] lastPositionOfCharacter = new int[26];

        for (int i = 0; i < input.length(); i++) {
            lastPositionOfCharacter[input.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            last = Math.max(last, lastPositionOfCharacter[input.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

}
