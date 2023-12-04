package com.sunandan.permutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CoinChangeProblemTest {

    private CoinChangeProblem ccp = new CoinChangeProblem();

    @Test
    public void testMethodGetDenomination(){
        List<List<Integer>> result = ccp.getDenomination(Arrays.asList(1, 2, 3), 4);
        System.out.println(result);
        assertEquals(Arrays.asList(Arrays.asList(1,1,1,1), Arrays.asList(2,1,1),
                Arrays.asList(1,2,1), Arrays.asList(3,1), Arrays.asList(1,1,2),
                Arrays.asList(2,2), Arrays.asList(1,3)), result);
    }

    @Test
    public void testMethodGetDenominationFor5(){
        List<List<Integer>> result = ccp.getDenomination(Collections.singletonList(4), 4);
        assertEquals(Collections.singletonList(Collections.singletonList(4)), result);
        System.out.println(result);
    }

    @Test
    public void testMethodGetDenominationForValueLessThanCoin(){
        List<List<Integer>> result = ccp.getDenomination(Collections.singletonList(4), 3);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testMethodGetDenominationWhenNotPossible(){
        List<List<Integer>> result = ccp.getDenomination(Collections.singletonList(4), 7);
        assertEquals(Collections.emptyList(), result);
    }

}