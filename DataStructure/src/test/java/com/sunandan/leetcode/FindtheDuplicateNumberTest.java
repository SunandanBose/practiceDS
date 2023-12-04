package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindtheDuplicateNumberTest {

    private FindtheDuplicateNumber findtheDuplicateNumber = new FindtheDuplicateNumber();

    @Test
    public void testFindDuplicate() {
        int[] input = {1,3,4,2,2};
        assertEquals(2, findtheDuplicateNumber.findDuplicate(input));
    }
}