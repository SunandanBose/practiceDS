package com.sunandan.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Permutation {

    static Queue<String> queueList = new LinkedList<String>();

    public static void main(String[] args) {
        String str = "ABC";
        queueList.add(Character.toString(str.charAt(0)));
        permute(str);
        queueList.stream().collect(Collectors.toSet()).forEach(System.out::println);
    }

    private static void permute(String str) {
        while (true) {
            if (queueList.peek().length() == str.length())
                return;
            getPermutationsOfString(str, queueList.peek(), 0);
            queueList.remove();
        }
    }

    private static void getPermutationsOfString(String str, String newstr, int index) {
        if (index > newstr.length()) return;
        queueList.add(new StringBuffer().append(newstr).insert(index, str.charAt(newstr.length())).toString());
        getPermutationsOfString(str, newstr, index += 1);
    }

    public List<String> getPermutation(String str) {
		List<String> result = new ArrayList<>();
		result.add(str.substring(0,1));
		while(result.get(0).length() < str.length()){
			String temp = result.get(0);
			result.addAll(addCharacterInIndex(temp, str.charAt(temp.length())));
			result.remove(0);
		}
		return result;
    }

    private List<String> addCharacterInIndex(String input, char valueToAdd) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= input.length(); i++) {
            result.add(input.substring(0, i) + valueToAdd + input.substring(i));
        }
        return result;
    }

}
