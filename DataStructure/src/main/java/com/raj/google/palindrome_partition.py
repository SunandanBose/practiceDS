s = 'AABC'

def findMinCutsForPalindromeSubstrings(s):
    if len(s) == 1:
        return 0
    stringIsPalindrome = s[::-1] == s
    if stringIsPalindrome:
        return 0
    bestSolution = len(s)
    for i in range (1, len(s)):
        left = findMinCutsForPalindromeSubstrings(s[:i])
        right = findMinCutsForPalindromeSubstrings(s[i:])
        cuts = left + 1 + right
        if cuts < bestSolution:
            bestSolution = cuts

    return bestSolution
    
print(findMinCutsForPalindromeSubstrings(s))
