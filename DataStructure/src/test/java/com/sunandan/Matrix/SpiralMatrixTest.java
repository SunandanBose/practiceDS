package com.sunandan.Matrix;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SpiralMatrixTest {

    private SpiralMatrix sm;

    @Before
    public void setUp(){
        sm = new SpiralMatrix();
        Integer[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    }

    @Test
    public void getSpiraListForA2DMatrixofTypeInteger() {
        Integer[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertEquals(sm.getSpiralMatrix(matrix),expectedList);
    }

    @Test
    public void getEmptySpiralListforEmpty2DMatrix(){
        Integer[][] matrix = new Integer[0][0];
        List<Integer> expectedList = Collections.emptyList();
        assertEquals(sm.getSpiralMatrix(matrix),expectedList);
    }

    @Test
    public void getSpiralListForSingleRowMatrix() {
        Integer[][] matrix = {{1,2,3,4}};
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);
        assertEquals(sm.getSpiralMatrix(matrix),expectedList);
    }

    @Test
    public void getSpiraListForA2DMatrixofTypeString() {
        String[][] matrix = {{"1","2"},{"3","4"}};
        List<String> expectedList = Arrays.asList("1", "2", "4", "3");
        assertEquals(sm.getSpiralMatrix(matrix),expectedList);
    }


}