lastLine=$(tail -n 1 README.md)
echo $lastLine
serialNumber=$(echo "$lastLine" | cut -d "|" -f1)
echo $((serialNumber+1))
newSerialNumber=$((serialNumber+1))
commit=$(git diff-tree --diff-filter=A --no-commit-id --name-status -r "$local_sha" | tr 'A ' ' ')
echo $commit 
IFS=' ' #setting space as delimiter  
read -ra ADDR <<<"$commit" #reading commit str as an array as tokens separated by IFS  
  
for i in "${ADDR[@]}"; #accessing each element of array  
do  
	echo Do you want of continue\?\(y\/n\)
	read ans
	if [[ "$ans" == "Y" || "$ans" == "y" ]]; then
    	echo Enter the code link for file $i
		read filename
		echo filename you have entered is $filename
		echo $newSerialNumber \| Distribute Candies to People \|[Explanation]\($filename\)\| [Code]\($i\)\|| >> README.md
	fi
	
	  
done
