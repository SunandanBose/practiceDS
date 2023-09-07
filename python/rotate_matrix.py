# https://leetcode.com/problems/rotate-image/submissions/

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        # It basically means reverse the matrix
        # and fold it on the diagonal
        
        left = 0
        right = len(matrix) - 1
        while left < right:
            matrix[left], matrix[right] = matrix[right], matrix[left]
            left += 1
            right -= 1
        
        for i in range (len(matrix)):
            for j in range(i, len(matrix)):
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
        
        
        