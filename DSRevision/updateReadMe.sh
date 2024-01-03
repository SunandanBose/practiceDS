#!/bin/bash



echo "Enter Problem Name:"
read input2

echo "Enter Explanation link:"
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

trimmed_string=$(echo "$input2" | sed 's/[[:space:]]*$//')

# Replace blank space between two words
formatted_string=$(echo "$trimmed_string" | sed 's/ //g')

# Append ".java" at the end
filename="${formatted_string}.java"


today_date=$(date +"%d-%b-%y")

# Form the line to be added
new_line="$number | $input2 | [Explanation]($input3) | [Code]($filename) | $today_date |"


# Add the line to the Readme.md file
echo "$new_line" >> "$readme_path"

echo "Line added successfully to $readme_path"
