package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuyAndSellStockIIITest {

    private BuyAndSellStockIII  bass = new BuyAndSellStockIII();

    @Test
    public void test1maxProfit() {
        int[] input = {3,3,5,0,0,3,1,4};
        assertEquals(6,bass.maxProfit(input));
    }

    @Test
    public void test2maxProfit() {
        int[] input = {1,2,3,4,5};
        assertEquals(4,bass.maxProfit(input));
    }

    @Test
    public void test3maxProfit() {
        int[] input = {7,6,4,3,1};
        assertEquals(0,bass.maxProfit(input));
    }
}