public class MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, 0, 0);
    }

    public int minPathSum(int[][] grid, int rowIndex, int colIndex) {
        if (rowIndex == (grid.length - 1) && colIndex == (grid[0].length - 1)) 
            return grid[rowIndex][colIndex];
        if (rowIndex  == (grid.length - 1)) 
            return grid[rowIndex][colIndex] + minPathSum(grid, rowIndex, colIndex + 1);
        if (colIndex  == (grid[0].length - 1)) 
            return grid[rowIndex][colIndex] + minPathSum(grid, rowIndex + 1, colIndex);
        return grid[rowIndex][colIndex] + Math.min(minPathSum(grid, rowIndex, colIndex + 1), 
                                minPathSum(grid, rowIndex + 1, colIndex));
    }
}