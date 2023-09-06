# https://leetcode.com/problems/count-and-say/

from collections import deque

class Solution:
    def countAndSay(self, n: int) -> str:
        answer = "1"
        if n == 1:
            return answer
        
        while n != 1:
            result = self.countChars(answer)
            answer = ''
            for k, v in result:
                answer += str(v) + k
            n = n - 1
        
        return answer
                
        
    
    def countChars(self, text: str) -> list:
        stack = deque()
        for c in text:
            k, v = stack[-1] if stack else [None, None]
            if c == k:
                stack[-1] = (k, v + 1)
            else:
                stack.append((c, 1))
        
        return stack