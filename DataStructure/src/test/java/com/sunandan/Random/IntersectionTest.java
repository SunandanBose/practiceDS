package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionTest {

    private Intersection intersection = new Intersection();

    @Test
    public void testGetIntersection() {
        assertArrayEquals(new int[]{2}, intersection.getIntersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

}