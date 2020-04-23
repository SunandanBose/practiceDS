package com.sunandan.permutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CoinChangeProblemTest {

    private CoinChangeProblem ccp = new CoinChangeProblem();

    @Test
    public void testMethodGetDenomination(){
        ccp.getDenomination(new ArrayList<>(), Arrays.asList(1,2,3),4);
        int[][] expected = {{1,1,1,1},};
    }

}