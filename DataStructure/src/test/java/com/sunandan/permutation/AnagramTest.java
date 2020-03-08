package com.sunandan.permutation;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AnagramTest {

    private Anagram a;

    @Before
    public void setUp(){
        a= new Anagram();
    }

    @Test
    public void checkIfAllAnagramsAreDetecting() {
        List<String> inputList = Arrays.asList("abc", "edf", "cab", "fed", "bca", "jhg");
        Map<String,Integer> resultMap = a.getAnagramsInList(inputList);
        Map<String,Integer> expectedValue = new HashMap<>();
        expectedValue.put("abc",3);
        expectedValue.put("def",2);
        expectedValue.put("ghj",1);
        assertTrue(resultMap.equals(expectedValue));
    }

    @Test
    public void checkforEmptyList() {
        List<String> inputList = Collections.emptyList();
        Map<String,Integer> resultMap = a.getAnagramsInList(inputList);
        Map<String,Integer> expectedValue = new HashMap<>();
        assertTrue(resultMap.equals(expectedValue));
    }
}