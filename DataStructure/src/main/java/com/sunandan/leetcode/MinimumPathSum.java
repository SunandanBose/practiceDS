package com.sunandan.leetcode;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        return minPathSum(grid, grid.length-1, grid[0].length-1);
    }

    private int minPathSum(int[][] grid, int row, int col){
        if(row == 0 && col == 0)
            return grid[0][0];
        if(row == 0) return grid[0][col] + minPathSum(grid, 0, col-1);
        if(col == 0) return grid[row][0] + minPathSum(grid, row-1, 0);
        return grid[row][col] + Math.min(minPathSum(grid, row, col-1) , minPathSum(grid, row-1, col));
    }

}
