#!/bin/bash



echo "Enter Input 2:"
read input2

echo "Enter Input 3 (Explanation link):"
read input3

# Specify the path to your Readme.md file
readme_path="./README.md"

number=-1
# Check if the file exists
if [ -f "$readme_path" ]; then
    # Read the last line of the file and store it in a variable
    last_line=$(tail -n 1 "$readme_path")

    number=$(echo "$last_line" | awk -F '|' '{print $1}' | tr -d '[:space:]')
    ((number++))
    echo "New number: $number"
    echo "Last line of $readme_path: $last_line: $number"
fi

filename=$(echo "$input2" | sed -e 's/[[:space:]]*$//')

# Replace blank spaces with noSpace
filename=$(echo "$filename" | tr ' ' '')

# Ensure the filename ends with ".java"
filename="${filename}.java"

# Form the line to be added
new_line="$number | $input2 | [Explanation]($input3) | [Code]($filename) | |"


# Add the line to the Readme.md file
echo "$new_line" >> "$readme_path"

echo "Line added successfully to $readme_path"
