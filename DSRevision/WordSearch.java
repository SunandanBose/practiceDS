class WordSearch {
    public static void main(String[] args) {
        char[][] board =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED"));// true
        System.out.println(wordSearch.exist(board, "SEE"));// true
        System.out.println(wordSearch.exist(board, "ABCB"));// false
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
                if (findNextWord(board, word, 0, i, j, ""))
                    return true;
            }
        }
        return false;
    }

    public boolean findNextWord(char[][] board, String word, int nextCharInWordPosition, int row, int column, String result) {
        if(word.equals(result))
            return true;
        if (!checkBoundry(board, row, column))
            return false;
        char nextCharInBoard = board[row][column];
        char nextCharInWord = word.charAt(nextCharInWordPosition);
        boolean finalResult = false;
        if(nextCharInBoard == nextCharInWord) {
            board[row][column] = '0';
            result += nextCharInBoard;
            finalResult = findNextWord(board, word, nextCharInWordPosition + 1, row + 1, column, result) || findNextWord(board, word, nextCharInWordPosition + 1, row, column + 1, result) || findNextWord(board, word, nextCharInWordPosition + 1, row - 1, column, result) || findNextWord(board, word, nextCharInWordPosition + 1, row, column - 1, result);
            board[row][column] = nextCharInBoard;
        }
        return finalResult;
    }

    public boolean checkBoundry(char[][] board, int row, int column) {
        int rowSize = board.length;
        int colSize = board[0].length;
        if((row >= 0 && row < rowSize) && (column >= 0 && column < colSize)) 
            return true;
        return false;
    }
}