package com.sunandan.google;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MajorityElementIITest {

    private MajorityElementII majorityElementII = new MajorityElementII();

    @Test
    public void majorityElement() {
        int[] input = {3,2,3};
        assertEquals(Arrays.asList(3),majorityElementII.majorityElement(input));
    }
}