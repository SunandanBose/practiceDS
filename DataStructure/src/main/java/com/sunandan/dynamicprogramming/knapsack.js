function knapsack(values,weights,W){
    weightToValueMap = {}
    valueToWeightRatioMap = {}
    result = [];
    weights.forEach((weight, index) => { 
        weightToValueMap[weight] = values[index];
        valueToWeightRatioMap[values[index]/weight] = weight;
    });
    sortedratio = Object.keys(valueToWeightRatioMap).sort().reverse();
    i = 0;
    while(W > 0){
        if(i > sortedratio.length) break;
        weight = valueToWeightRatioMap[sortedratio[i]]
        if(weight > W){
            i++;
            continue;
        }
        result.push(weightToValueMap[weight]);
        W -= weight;
    }
    return result;
}

console.log(knapsack([4,2,1,10,2],[12,2,1,4,1],15))



