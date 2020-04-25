function kadaneAlgo(matrix){
    let maxValue = matrix[0];
    let currentSum = matrix[0];
    let currentSubArray = [];
    for(let i=1;i<matrix.length;i++){
        if((currentSum + matrix[i]) < matrix[i] ){
            currentSubArray = [matrix[i]];
            currentSum = matrix[i];
            maxValue = matrix[i];
            continue;
        }
        currentSum += matrix[i];
        currentSubArray.push(matrix[i]);
        if(currentSum > maxValue)
            maxValue = currentSum;
    }
    return maxValue;
}

console.log(kadaneAlgo([-2,4,5,1,-8,11]));


