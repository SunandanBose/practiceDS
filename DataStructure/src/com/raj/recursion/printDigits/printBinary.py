import sys

def printBinary(digits, prefix = ""):
	if (digits == 0):
		print( prefix )
	else:
		printBinary(digits - 1, prefix + "0")
		printBinary(digits - 1, prefix + "1")

def printDecimal(digits, prefix = ""):
	if digits == 0:
		print( prefix )
	else:
		for num in range(0,10):
			printDecimal(digits - 1, prefix + str(num))

printBinary(int(sys.argv[1]))
print (" -------- X --------- X --------- ")
printDecimal(int(sys.argv[1]))
