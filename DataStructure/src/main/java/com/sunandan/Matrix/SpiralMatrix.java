package com.sunandan.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix<T> {


    public List<T> getSpiralMatrix(T[][] matrix) {
        List<T> ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int matrix_row_length = matrix.length, matrix_column_length = matrix[0].length;
        boolean[][] visited = new boolean[matrix_row_length][matrix_column_length];
        int[] row_dir = {0, 1, 0, -1};
        int[] col_dir = {1, 0, -1, 0};
        int row_indx = 0, col_indx = 0, dir = 0;
        for (int i = 0; i < matrix_row_length * matrix_column_length; i++) {
            ans.add(matrix[row_indx][col_indx]);
            visited[row_indx][col_indx] = true;
            int curr_row_indx = row_indx + row_dir[dir];
            int curr_col_indx = col_indx + col_dir[dir];
            if (0 <= curr_row_indx && curr_row_indx < matrix_row_length && 0 <= curr_col_indx && curr_col_indx < matrix_column_length && !visited[curr_row_indx][curr_col_indx]){
                row_indx = curr_row_indx;
                col_indx = curr_col_indx;
            }
            else {
                dir = (dir + 1) % 4;
                row_indx += row_dir[dir];
                col_indx += col_dir[dir];
            }
        }
        return ans;
    }
}
