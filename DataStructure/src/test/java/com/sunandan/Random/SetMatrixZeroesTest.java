package com.sunandan.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetMatrixZeroesTest {

    private SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

    @Test
    public void setZeroes() {
        int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        assertArrayEquals(expected, setMatrixZeroes.setZeroes(input));
    }
}