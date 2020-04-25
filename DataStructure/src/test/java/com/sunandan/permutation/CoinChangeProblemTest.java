package com.sunandan.permutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CoinChangeProblemTest {

    private CoinChangeProblem ccp = new CoinChangeProblem();

    @Test
    public void testMethodGetDenomination(){
        List<List<Integer>> result = ccp.getDenomination(Arrays.asList(1, 2, 3), 4);
        System.out.println(result);
    }

    @Test
    public void testMethodGetDenominationFor5(){
        List<List<Integer>> result = ccp.getDenomination(Arrays.asList(4), 4);
        System.out.println(result);
    }

}