package com.sunandan.google;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

    Map<String, Integer> visitedStringMap = new HashMap<String, Integer>();

    public int getMinSteps(String actualString, String toModify) {
        int length1 = actualString.length();
        int length2 = toModify.length();
        if (visitedStringMap.get(actualString + actualString) != null)
            return visitedStringMap.get(actualString + toModify);
        if (length1 == 0)
            return length2;
        if (length2 == 0)
            return length1;
        if (actualString.charAt(length1 - 1) == toModify.charAt(length2 - 1))
            return getMinSteps(actualString.substring(0, length1 - 1), toModify.substring(0, length2 - 1));
        int insert = getMinSteps(actualString, toModify.substring(0, length2 - 1));
        int delete = getMinSteps(actualString.substring(0, length1 - 1), toModify);
        int replace = getMinSteps(actualString.substring(0, length1 - 1), toModify.substring(0, length2 - 1));
        visitedStringMap.put(actualString + toModify, 1 + Math.min(Math.min(insert, delete), replace));
        return visitedStringMap.get(actualString + toModify);
    }
}
