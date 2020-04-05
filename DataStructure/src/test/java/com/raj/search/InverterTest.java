package com.raj.search;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class InverterTest {


    private Inverter inv = new Inverter();

    @Test
    public void testFindLimitsToGetLowerLimit144AndUpperLimit288ForValue18() {
        Limit limit = inv.findLimits(x -> x.divide(BigInteger.TEN), new BigInteger("18"));
        assertTrue(limit.upper.compareTo(new BigInteger("288")) == 0);
        assertTrue(limit.lower.compareTo(new BigInteger("144")) == 0);
    }

    @Test
    public void testBinarySearchValue18ForAnswer180() {
        Limit limit = inv.findLimits(x -> x.divide(BigInteger.TEN), new BigInteger("18"));
        BigInteger x = inv.binarySearch(y -> y.divide(BigInteger.TEN), limit, new BigInteger("18"));
        assertTrue(new BigInteger("188").compareTo(x) == 0);
    }

    @Test
    public void testBinarySearchValue180ShouldGetAnswer18() {
        Limit limit = new Limit(BigInteger.ZERO,BigInteger.valueOf(100L));
        BigInteger x = inv.binarySearch(y -> y.multiply(BigInteger.TEN), limit, new BigInteger("180"));
        assertTrue(new BigInteger("18").compareTo(x) == 0);
    }

    @Test
    public void testBinarySearchValue18ShouldGetAnswer2() {
        Limit limit = new Limit(BigInteger.ZERO,BigInteger.valueOf(100L));
        BigInteger x = inv.binarySearch(y -> y.multiply(BigInteger.TEN), limit, new BigInteger("18"));
        assertNull(x);
    }
}