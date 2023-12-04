package com.sunandan.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    private  GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    public void TestGroupAnagrams() {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("eat", "tea", "ate"), Arrays.asList("bat"), Arrays.asList("tan", "nat"));
        assertEquals(expected, groupAnagrams.groupAnagrams(input));
    }
}