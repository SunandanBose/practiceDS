
// Find the Maximum Number of Times an odd Number is continously repeated in the array

function LongestOddFreq(input){
    let freq = {};
    for(let i = 0; i < input.length; i++){
        if(input[i]%2===0)  continue;
        for(let j=i; j < input.length; j++){
            if(input[i] !== input[j] || j == input.length-1){
                if(freq[input[i]]){
                    if(freq[input[i]] < j-i){
                        freq[input[i]] = j-i;
                        j == input.length-1 ? i = j : i = j-1;  
                        break;
                    }
                }
                freq[input[i]] = j-i;
                j == input.length-1 ? i = j : i = j-1;
                break;
            }     
        }
    }
    return Object.values(freq).sort().reverse()[0];
}

console.log(LongestOddFreq(['1', '1', '1', '1', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1', '1','3','3','3','3']));



