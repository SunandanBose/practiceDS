adjacencyList = {
	'5': ['2', '3', '4'],
	'2': [],
	'3': [],
	'4': ['6'],
	'6': ['2']
}

allNodes = list(adjacencyList.keys())
stack = []
uniqueValuesSet = set() # 5

def func(allNodes):
	for node in allNodes:
		if node in uniqueValuesSet:
			continue
		uniqueValuesSet.add(node)
		if len(adjacencyList[node]) == 0:
			stack.append(node)
		else:
			func(adjacencyList[node])
			stack.append(node)

func(allNodes)			
stack.reverse()
print (stack)
