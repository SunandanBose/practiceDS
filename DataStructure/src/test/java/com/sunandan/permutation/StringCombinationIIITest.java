package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCombinationIIITest {

    StringCombinationIII sc3 = new StringCombinationIII();

    @Test
    public void test1ContainsNearbyAlmostDuplicate() {
        int[] input = {1,2,3,1};
        assertEquals(true, sc3.containsNearbyAlmostDuplicate(input, 3, 0));
    }

    @Test
    public void test2ContainsNearbyAlmostDuplicate() {
        int[] input = {1,0,1,1};
        assertEquals(true, sc3.containsNearbyAlmostDuplicate(input, 1, 2));
    }

    @Test
    public void test3ContainsNearbyAlmostDuplicate() {
        int[] input = {1,5,9,1,5,9};
        assertEquals(false, sc3.containsNearbyAlmostDuplicate(input, 2, 3));
    }

}