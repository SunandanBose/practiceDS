import pprint
import random

w, h = 4, 5;
# Generating a random grid of 0s and 1s
# 0s are blocks and 1s are valid

grid = [
[1, 1, 0, 0], 
[0, 1, 1, 0], 
[0, 0, 1, 1], 
[1, 1, 1, 0], 
[1, 0, 1, 1]
]

# grid = [[random.randint(0, 1) for x in range(w)] for y in range(h)] 
# pprint.pprint(grid)

stack = []

columnIndex = 0
rowIndex = 0
while (1):
	if 	grid[rowIndex][columnIndex] is 1:
		stack.append((i, columnIndex))
	else:
		break;
	if rowIndex == len(grid) && columnIndex == len(grid[rowIndex])
	if grid[rowIndex + 1][columnIndex] is 1:
		rowIndex+=1
	elif grid[rowIndex][columnIndex + 1] is 1:
		columnIndex+=1



stack	0,0		0,1		1,1		1,2		2,2		3,2		4,2	
rowIndex	0	1	2
columnIndex	0	1	2