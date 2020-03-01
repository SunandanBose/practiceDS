import sys

countOfSteps={0: 1, 1: 1, 2: 2, 3: 4}
def triple(n):
	# Memoization check if already present in dictionary
	if (-1 != countOfSteps.get(n, -1)):
		return countOfSteps[n]

	# Number of steps is equal to sum of steps a child can 
	# cover the previous 3 steps.
	numberOfSteps = triple(n-1) + triple(n-2) + triple(n-3)
	countOfSteps[n] = numberOfSteps
	return numberOfSteps

print triple(int(sys.argv[1]))

