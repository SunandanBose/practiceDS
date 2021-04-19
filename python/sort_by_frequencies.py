input = [1,2,3,1,2,3,3,2,3,3,2]

frequencies = {}

for el in input:
	if el in frequencies:
		frequencies[el] += 1
	else: frequencies[el] = 0

print(requencies)
result = []
for k,v in frequencies.items():
	result.append((k,v))
	for i in range(len(result) - 1, 0, -1):
		if result[i][1] > result[i - 1][1]:
			temp = result[i]
			result[i] = result[i-1]
			result[i-1] = temp
			continue
		if result[i][1] == result[i - 1][1] and result[i][1] > result[i - 1][1]:
			temp = result[i]
			result[i] = result[i-1]
			result[i-1] = temp
			continue
		else: 
			break
        
print(result)
print([el[0] for el in result])
