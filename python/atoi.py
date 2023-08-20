# https://leetcode.com/problems/string-to-integer-atoi/description/

class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        sign = '+'

        if not s:
            return 0

        if s[0] == '-' or s[0] == '+':
            sign = s[0]
            s = s[1:]
        
        result = ''
        max_int = pow(2, 31) - 1
        min_int = pow(2, 31) * -1
        for char in s:
            if char.isdigit():
                result += char
            else:
                break
        
        if result:
            if sign == '-':
                result = int(result) * -1
            else:
                result = int(result)
            
            if result > max_int:
                return max_int
            if result < min_int:
                return min_int
            return result

        return 0