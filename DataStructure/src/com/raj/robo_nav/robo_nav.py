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
