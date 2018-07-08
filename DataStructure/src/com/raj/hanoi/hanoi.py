from itertools import cycle
stack1 = [5,4,3,2,1]
stack2, stack3 = [],[]
stacks = [stack1, stack2, stack3]


def available():
	currentIndex = 0
	counter = 0
	while(1):
		counter+=1
		currentStack = stacks[currentIndex]
		if len(currentStack) is not 0:
			nextStack = stacks[(currentIndex + 1) % 3]
			if len(nextStack) is 0:
				nextStack.append(currentStack.pop())
				currentIndex = (currentIndex+2) % 3
				continue
			elif len(nextStack) > 0 and currentStack[len(currentStack) - 1] < nextStack[len(nextStack) - 1]:
				nextStack.append(currentStack.pop())
				currentIndex = (currentIndex+2) % 3
				continue
			else:
				nextStack = stacks[(currentIndex + 2) % 3]
				if len(nextStack) is 0:
					nextStack.append(currentStack.pop())
					currentIndex = (currentIndex + 3) % 3
					continue
				if len(nextStack) > 0 and currentStack[len(currentStack) - 1] < nextStack[len(nextStack) - 1]:
					nextStack.append(currentStack.pop())
					currentIndex = (currentIndex+3) % 3
					continue
		currentIndex = (currentIndex + 1) % 3
		if len(stack3) == 5:
			break

	print stacks
	print counter

available()
