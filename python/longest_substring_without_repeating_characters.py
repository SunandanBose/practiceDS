# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Start creating a substring
        # Keep adding characters until you find a repeated character
        # As soon as you find a repeated character change the substring to start after the repeated character
        # Continue
        sub = ''
        longest_substring = 0
        for c in s:
            if c not in sub:
                sub += c
                longest_substring = max(longest_substring, len(sub))

            else:
                longest_substring = max(longest_substring, len(sub))
                index_of_unique_char = sub.find(c)
                sub = sub[index_of_unique_char + 1:] + c

        return longest_substring


