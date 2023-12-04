
// Find the Maximum Number of Times an odd Number is continously repeated in the array

function LongestOddFreq(input){
    let maxCounter = 0;
    let current = -1;
    let currentCounter = 0;
    for(let i = 0; i < input.length; i++){
        if(input[i] % 2 === 0) {
            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
            }
            current = input[i + 1]
            currentCounter = 0;
            continue;
        }
        if(input[i] !== current) {
            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
            }
            current = input[i]
            currentCounter = 1;
            continue;
        }
        currentCounter++;
    }
    return maxCounter || currentCounter;
}

 console.log(LongestOddFreq(['1', '1', '1', '1']));
 console.log(LongestOddFreq(['2', '2', '2', '2']));
 console.log(LongestOddFreq(['1', '2', '2', '2']));
 console.log(LongestOddFreq(['2', '2', '1', '2']));
 console.log(LongestOddFreq(['1', '1', '1', '1', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1', '1','3','3','3','3']));
 console.log(LongestOddFreq(['1','1','1','1','2','2','2','2','2','1','1','1']));


