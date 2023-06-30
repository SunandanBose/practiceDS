# Logic

# For string abc
# Take [a]
# Next take b put it in front of a and put it behind a -> [ab,ba]
# Next take c put it in all possible places for -> [ab,ba]
# So that will give [cab, acb, abc]
# and [cba, bca, bac]
# Combine the results to the list

def append_char(input: str, c: str):
	result = []
	for i in range(0, len(input) + 1):
		result.append(input[:i] + c + input[i:])

	# print(result)

	return result

def permute(input: str):
	if len(input) == 0:
		return []

	result = [input[0]]
	for i in range(1, len(input)):
		current_result = []
		for el in result:
			el_res = append_char(el, input[i])
			current_result.extend(el_res)
		result = current_result
	
	# print (result)
	
	return result

# append_char('a', 'c')
# append_char('ab', 'c')
import sys
input_str = sys.argv[1] if len(sys.argv) > 1 else 'abc'
print(permute(input_str))

