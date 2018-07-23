import sys
def multiply(num1, num2):
	print("{ num1 , "+ str(num1) +" num2 " + str(num2) + " }")
	if num1 == 0 or num2 == 0:
		return 0
	if num1 == 1:
		print("I'm exiting" + str(num2))
		return num2
	else:
		if num1 > 2:
			return (multiply(num1 - 2, num2)) + num2 + num2
		return (multiply(num1 - 1, num2)) + num2

print (multiply(int(sys.argv[1]), int(sys.argv[2])))