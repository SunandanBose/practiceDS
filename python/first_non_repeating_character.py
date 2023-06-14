def first_non_repeating_character(text):
    char_count = {}
    for char in text:
        char_count[char] = char_count.get(char, 0) + 1
    
    for char in text:
        if char_count.get(char) == 1:
            return char
    
    return None

print(first_non_repeating_character('aabbcccdeddsfgget'))