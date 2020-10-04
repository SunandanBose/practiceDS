package com.sunandan.permutation;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0)
            return "";

        Map<Character, Integer> charFrequencyOfT = new HashMap<Character, Integer>();

        //calculate frequency of each character
        for (int i = 0; i < T.length(); i++) {
            int count = charFrequencyOfT.getOrDefault(T.charAt(i), 0);
            charFrequencyOfT.put(T.charAt(i), count + 1);
        }

        int required = charFrequencyOfT.size();

        // filteredS = contains List of Pairs(Index and Character pair), of the characters from String S
        // which are present in String T
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (charFrequencyOfT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        // foundUniqueCharactersInWindow is used to keep track of how many unique characters in T
        // are present in the current window in its desired frequency.
        int leftPointer = 0, rightPointer = 0, foundUniqueCharactersInWindow = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> uniqueCharacterFreqInCurrentWindow = new HashMap<Character, Integer>();

        // windowDetails list of the form (window length, left, right)
        int[] windowDetails = {-1, 0, 0};

        while (rightPointer < filteredS.size()) {
            char ch = filteredS.get(rightPointer).getValue();
            int count = uniqueCharacterFreqInCurrentWindow.getOrDefault(ch, 0);
            uniqueCharacterFreqInCurrentWindow.put(ch, count + 1);

            if (uniqueCharacterFreqInCurrentWindow.get(ch).intValue() == charFrequencyOfT.get(ch).intValue()) {
                foundUniqueCharactersInWindow++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (leftPointer <= rightPointer && foundUniqueCharactersInWindow == required) {
                ch = filteredS.get(leftPointer).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(rightPointer).getKey();
                int start = filteredS.get(leftPointer).getKey();
                if (windowDetails[0] == -1 || end - start + 1 < windowDetails[0]) {
                    windowDetails[0] = end - start + 1;
                    windowDetails[1] = start;
                    windowDetails[2] = end;
                }

                uniqueCharacterFreqInCurrentWindow.put(ch, uniqueCharacterFreqInCurrentWindow.get(ch) - 1);
                if (charFrequencyOfT.containsKey(ch) && uniqueCharacterFreqInCurrentWindow.get(ch).intValue() < charFrequencyOfT.get(ch).intValue()) {
                    foundUniqueCharactersInWindow--;
                }
                leftPointer++;
            }
            rightPointer++;
        }
        return windowDetails[0] == -1 ? "" : S.substring(windowDetails[1], windowDetails[2] + 1);
    }

}
