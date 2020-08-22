lastLine=$(tail -n 1 README.md)
echo $lastLine
serialNumber=$(echo "$lastLine" | cut -d "|" -f1)
echo $((serialNumber+1))
newSerialNumber=$((serialNumber+1))
#$(git diff-tree --no-commit-id --name-status -r "$local_sha")
read filename
echo Your filename id $filename
echo $filename >> README.md
