# https://leetcode.com/problems/valid-sudoku/

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            repeatsInRow = {}
            repeatsInColumn = {}
            for j in range(9):
                currentElementInRow = board[i][j]

                if currentElementInRow in repeatsInRow:
                    return False
                if currentElementInRow != '.':
                    repeatsInRow[currentElementInRow] = True
                
                currentElementInColumn = board[j][i]

                if currentElementInColumn in repeatsInColumn:
                    return False
                if currentElementInColumn != '.':
                    repeatsInColumn[currentElementInColumn] = True
                    
        baseIndexRow = 0
        baseIndexColumn = 0
            
        for i in range(len(board)):
            repeatsInSquare = {}
            baseIndexRow = 3 * (i // 3)
            baseIndexColumn = 3 * (i % 3)
            
            print(baseIndexRow, baseIndexColumn)
            for j in range(3):
                for k in range(3):
                    currentElement = board[baseIndexRow + j][baseIndexColumn + k]
                    print(baseIndexRow + j, baseIndexColumn + k, currentElement)
                    if currentElement in repeatsInSquare:
                        return False
                    if currentElement != '.':
                        repeatsInSquare[currentElement] = True
            
        
        return True