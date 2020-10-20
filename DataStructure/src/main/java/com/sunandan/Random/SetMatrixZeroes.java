package com.sunandan.Random;

public class SetMatrixZeroes {


    boolean[][] visited = null;

    public int[][] setZeroes(int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    matrix = makeRowAndColumnZero(matrix, i, j);
                    visited[i][j] = true;
                }
                visited[i][j] = true;
            }
        }
        return matrix;
    }

    private int[][] makeRowAndColumnZero(int[][] matrix, int row, int column) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] == 0) continue;
            matrix[row][i] = 0;
            visited[row][i] = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] == 0) continue;
            matrix[i][column] = 0;
            visited[i][column] = true;
        }
        return matrix;
    }

}
