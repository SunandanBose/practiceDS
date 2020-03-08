package com.sunandan.Random;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ShuffleTest {

    private Shuffle shuffle;

    @Before
    public void setUp(){
        shuffle = new Shuffle();
    }

    @Test
    public void checkIfListIsShuffled() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        list = shuffle.shuffleList(list);
        assertNotEquals(Arrays.asList(1,2,3,4,5,6,7,8),list);
    }

    @Test
    public void testWithBlankList() {
        List<Integer> list = Collections.emptyList();
        List<Integer> shuffledlist = shuffle.shuffleList(list);
        assertEquals(list,shuffledlist);
    }
}