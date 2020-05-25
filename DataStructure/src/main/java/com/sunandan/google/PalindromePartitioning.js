function palindromePartition(stringInput, stringPartitionMap){
	if(stringPartitionMap[stringInput]){
		return stringPartitionMap[stringInput];
	}
	if(stringInput.length == 1)
		return 0;
	if(isPalindrome(stringInput))
		return 0;
	let partitions = [];
	for(let i = 1 ; i < stringInput.length; i++){
		stringPartitionMap[stringInput.substring(0,i)] = palindromePartition(stringInput.substring(0,i),stringPartitionMap);
		stringPartitionMap[stringInput.substring(i)] = palindromePartition(stringInput.substring(i),stringPartitionMap);
		partitions.push(stringPartitionMap[stringInput.substring(0,i)] + 1 + stringPartitionMap[stringInput.substring(i)]);
	}
	return Math.min.apply( Math, partitions);;
}

function isPalindrome(originalString){
	let reverseString = originalString.split("").reverse().join("");
	if(reverseString === originalString)  
		return true;
    return false;
}

console.log(palindromePartition("AABC",{}));
console.log(palindromePartition("AABCBD",{}));
console.log(palindromePartition("AABCDBD",{}));
console.log(palindromePartition("BANANA",{}));
