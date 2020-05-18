package com.sunandan.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MajorityElementTest {

    private MajorityElement<Integer> me = new MajorityElement<>();
    private MajorityElement<String> me1 = new MajorityElement<>();

    @Test
    public void testgetMajorityElement() {
        List<Integer> inputList =  Arrays.asList(2,1,2);
        assertEquals(new Integer(2),me.getMajorityElement(inputList));
    }

    @Test
    public void test2getMajorityElement() {
        List<String> inputList =  Arrays.asList("a","b","a","a","a","b");
        assertEquals("a",me1.getMajorityElement(inputList));
    }

    @Test
    public void test3getMajorityElementForNull() {
        assertEquals(null,me1.getMajorityElement(new ArrayList()));
    }
}