inputSet = ['a', 'b', 'c', 'd']
resultSet = ['']

def powerset(inputSet):
	for x in inputSet:
		newSet = []
		for element in resultSet:
			value = x + element
			newSet.append(value)
		resultSet.extend(newSet)

	return resultSet

print (powerset(inputSet))