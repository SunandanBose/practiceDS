import java.util.HashSet;
import java.util.Set;

public class ValidSoduko {

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(!doesRowContainDuplicate(board, i))
                return false;
        }
        for(int i = 0; i < 9; i++) {
            if(!doesColContainDuplicate(board, i))
                return false;
        }
        for(int i = 0; i < board.length - 1; i+=3){
            for(int j = 0; j < board[0].length - 1; j+=3){
                if(!doesGridContainDuplicate(board, i, j))
                    return false;
            }
        }
        return true;
    }

    private boolean doesColContainDuplicate(char[][] board, int col) {
        Set<Character> dictionary = new HashSet<>();
        for(int i = 0; i < 9; i++){
            if(board[i][col] == '.') continue;
            if(dictionary.contains(board[i][col])) 
                return false;
            dictionary.add(board[i][col]);
        }
        return true;
    }

    private boolean doesRowContainDuplicate(char[][] board, int row) {
        Set<Character> dictionary = new HashSet<>();
        for(int i = 0; i < 9; i++){
            if(board[row][i] == '.') continue;
            if(dictionary.contains(board[row][i])) 
                return false;
            dictionary.add(board[row][i]);
        }
        return true;
    }

    private boolean doesGridContainDuplicate(char[][] board, int row, int col) {
        Set<Character> dictionary = new HashSet<>();
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(board[i][j] == '.') continue;
                if(dictionary.contains(board[i][j])) 
                    return false;
                dictionary.add(board[i][j]);
            }
        }
        return true;
    }
}