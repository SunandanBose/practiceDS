import sys

def reverse(string:str) -> str:
	reverse = ''
	for i in range(len(string) - 1, -1, -1):
		reverse = reverse + string[i]
	print(reverse)
	return reverse

reverse(sys.argv[1])
