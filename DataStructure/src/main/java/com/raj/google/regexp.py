string s = 'abcd'

string regex = "a.b"

"a.....***bb"
"a*b"

string_index = 0
regex_index = 0

def isMatch():
    while string_index != len(s):
        if s[regex_index] != '.' || s[regex_index] != '*':
            if s[string_index] != regex[regex_index]:
                return False
            string_index += 1
            regex_index += 1
        if regex[regex_index] == '.':
            string_index += 1
            regex_index += 1
        if regex[regex_index + 1] == '*':
            regex_index += 1

