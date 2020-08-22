lastLine=$(tail -n 1 README.md)
echo $lastLine
serialNumber=$(echo "$lastLine" | cut -d "|" -f1)
echo $((serialNumber+1))