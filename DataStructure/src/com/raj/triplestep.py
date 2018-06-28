import sys

countOfTriples={0: 1, 1: 1, 2: 2, 3: 4}
def triple(n):
	if (-1 != countOfTriples.get(n, -1)):
		return countOfTriples[n]
	countOfN = triple(n-1) + triple(n-2) + triple(n-3)
	countOfTriples[n] = countOfN
	return countOfN

print triple(int(sys.argv[1]))

