lastLine=$(tail -n 1 README.md)
echo $lastLine
serialNumber=$(echo "$lastLine" | cut -d "|" -f1)
echo $((serialNumber+1))
newSerialNumber=$((serialNumber+1))
newlyAddedFileNames=$(git diff-tree --diff-filter=A --no-commit-id --name-status -r "$local_sha" | tr 'A ' ' ')
echo $commit 
IFS=' ' #setting space as delimiter  
read -ra fileArray <<<"$newlyAddedFileNames" #reading commit str as an array as tokens separated by IFS  
  
for i in "${fileArray[@]}";
do  
	echo Do you want to continue\?\(y\/n\)
	read ans
	if [[ "$ans" == "Y" || "$ans" == "y" ]]; then
    	echo Enter the code link for file $i
		read codeLink
		echo codeLink you have entered is $codeLink
		echo $newSerialNumber \| Distribute Candies to People \|[Explanation]\($codeLink\)\| [Code]\($i\)\|| >> README.md
	fi
	
	  
done
