public class SurroundedRegions {
    

    public void solve(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2)
            return;

        
        for(int i = 1; i < board.length-1; i++) {
           if(board[i][0] == 'O')
                checkForAdjacentValues(board, i, 0);
           if(board[i][board[0].length-1] == 'O')
                checkForAdjacentValues(board, i, board[0].length-1);
        }
        for(int j = 1; j < board[0].length-1; j++) {
           if(board[0][j] == 'O')
                checkForAdjacentValues(board, 0, j);
           if(board[board.length-1][j] == 'O')
                checkForAdjacentValues(board, board.length-1, j);
        }
        
        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }

    public void checkForAdjacentValues(char[][] board, int row, int column) {
        if(row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1 || board[row][column] == 'X')
            return;
        if(board[row][column] == 'O')
            board[row][column] = 'Y';
        if(row > 1 && board[row-1][column] == 'O')
            checkForAdjacentValues(board, row-1, column);
        if(row < board.length - 2 && board[row+1][column] == 'O')
            checkForAdjacentValues(board, row+1, column);
        if(column < board[0].length - 2 && board[row][column+1] == 'O')
            checkForAdjacentValues(board, row, column+1);
        if(column > 1 && board[row][column-1] == 'O')
            checkForAdjacentValues(board, row, column-1);
    }
}
