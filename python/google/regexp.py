s = 'aaaaab'
s1 = 'db'
regex = "a*b"

# "."
# "a.*b"
# "a.b"
# "a*b"
# "c.*d.e" d.e dde
# ""
# "c*a*b*de*"
# "c* a* b* d e*"
# a b c. d.e

1
11
121
1331
regex = 'b'
s = 'db'

if regex is empty return string.isempty
if string has character
match first character with first character of regex
if not match return false
if second character is *
call self with (same regex, next character) or 


def isMatch(regex, string):
    tokens = regex.split('*')
    for token in tokens:
        string_index = 0
        for char in string:
            if token != char:
                isMatch('*'.join(regex[1:]) ,string[string_index:])
                break
            if token == char:
                string_index += 1
        
        isMatch('*'.join(regex[1:]) ,string[string_index:])


        

print(isMatch(s, regex))