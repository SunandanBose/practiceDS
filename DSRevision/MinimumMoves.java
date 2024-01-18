import java.util.*;;
/**
 * MinimumMoves
 */
public class MinimumMoves {
    public static void main(String[] args) {
        List<List<Integer>> maze = new ArrayList<>();
        maze.add(Arrays.asList(0,0,0));
        maze.add(Arrays.asList(1,0,0));
        maze.add(Arrays.asList(0,0,0));
        System.out.println(new MinimumMoves().getMinimumMoves(maze, 3));
    }

    public int getMinimumMoves(List<List<Integer>> maze, int k) {
        boolean[][] visited = new boolean[maze.size()][maze.get(0).size()];
        return getMinimumMoves(maze, 0, 0, k, visited);
    }

    public int getMinimumMoves(List<List<Integer>> maze, int row, int col, int k, boolean[][] visited) {
        int rowLength = maze.size();
        int colLength = maze.get(0).size();
        int minMove = Integer.MAX_VALUE;
        if(row == rowLength - 1 && col == colLength - 1)
            return 0;
        for(int i = 1; i<=k; i++) {
            visited[row][col] = true;
            int right = Integer.MAX_VALUE, left = Integer.MAX_VALUE, up = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
            if(isValid(maze, row + i, col, k, visited, rowLength, colLength)){
                down = getMinimumMoves(maze, row + i, col, k, visited);
            } 
            if(isValid(maze, row - i, col, k, visited, rowLength, colLength)){
                up = getMinimumMoves(maze, row + i, col, k, visited);
            }
            if(isValid(maze, row, col + i, k, visited, rowLength, colLength)){
                right = getMinimumMoves(maze, row, col + i, k, visited);
            }
            if(isValid(maze, row, col - i, k, visited, rowLength, colLength)){
                left = getMinimumMoves(maze, row, col - i, k, visited);
            }  
            int min = Math.min(left, Math.min(right, Math.min(up, down)));
            minMove = Math.min(min, minMove);
        }
        return 1 + minMove;   
    }

    private boolean isValid(List<List<Integer>> maze, int row, int col, int k, boolean[][] visited, int rowLength, int colLength) {
        if(row >= 0 && row < rowLength && col >= 0 && col < colLength && maze.get(row).get(col) == 0 && !visited[row][col])
            return true;
        return false;
    }
}