# https://leetcode.com/problems/longest-common-prefix/

def longestCommonPrefix(strings: list[str]) -> str:
	res = ''
	current_char = strings[0][0]
	current_char_index = 0
	stop = False

	while stop != True:
		for string in strings:
			if current_char != string[current_char_index]:
				stop = True
				break
		current_char_index = current_char_index + 1
		if stop != True:
			res = res + current_char

		if current_char_index < len(strings[0]):
			current_char = strings[0][current_char_index] 

	return res

print(longestCommonPrefix(['abc', 'abd', 'abe']))
