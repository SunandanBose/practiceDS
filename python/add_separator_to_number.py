import sys

def add_separator(input: str) -> str:
	result = ''
	count = 0
	for i in range(len(input) - 1, -1, -1):
		if count == 3:
			result = result + ','
			count = 0
		result = result + input[i]
		count = count + 1

	print(result[::-1])

add_separator(sys.argv[1])