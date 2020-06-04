def isInterLeave(A, B, C):
    res = False
    resA = False
    resB = False
    if not A and not B and not c:
        return True
    if not A:
        return B == C
    if not B:
        return A == C

    print(locals())
    if A[0] == C[0]:
        resA = isInterLeave(A[1:], B, C[1:])
    if B[0] == C[0]:
        resB = isInterLeave(A, B[1:], C[1:])
    res = resA or resB
    return res

print(isInterLeave('aa', 'bb', 'aabb'))
print(isInterLeave('aba', 'bb', 'abbba'))
print(isInterLeave('aabcc', 'dbbca', 'aadbbcbcac'))