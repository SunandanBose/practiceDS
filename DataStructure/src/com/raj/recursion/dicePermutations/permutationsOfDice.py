import sys

def diceRolls(die, choices = []):
	if die == 0:
		print (choices)
	else:
			# Rolling dice from 1 to 6
		for roll in range(1,7):
			choices.append(roll)
			# Rolling remaining dices
			diceRolls(die - 1, choices)
			# Backtracking
			choices.pop()

diceRolls(int(sys.argv[1]))