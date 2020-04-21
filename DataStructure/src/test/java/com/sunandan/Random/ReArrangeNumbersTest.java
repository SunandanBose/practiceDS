package com.sunandan.Random;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReArrangeNumbersTest {

    private ReArrangeNumbers ran = new ReArrangeNumbers();

    @Test
    public void testGetLargestNumberTest1() {
        assertEquals(ran.getLargestNumber(new Integer[]{54, 546, 548, 60}),"6054854654");
    }

    @Test
    public void testGetLargestNumberTest2() {
        assertEquals(ran.getLargestNumber(new Integer[]{1, 34, 3, 98, 9, 76, 45, 4}),"998764543431");
    }

    @Test
    public void testGetLargestNumberTest3() {
        assertEquals(ran.getLargestNumber(new Integer[]{15,4}),"415");
    }

    @Test
    public void testGetLargestNumberTest4() {
        assertEquals(ran.getLargestNumber(new Integer[]{75,68,21,12,10,7}),"77568211210");
    }
}