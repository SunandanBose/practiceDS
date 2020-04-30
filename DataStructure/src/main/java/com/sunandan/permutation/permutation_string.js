function permutation(inputString){
    queue = [];
    queue.push(inputString.charAt(0));
    while(queue[0].length < inputString.length){
        let value = queue[0];
        queue.shift();
        for(let i=0;i<=value.length; i++){
            let str = value.slice(0,i)+ inputString.charAt(value.length) + value.slice(i);
            queue.push(str);
        }
    }
    return queue;
}

console.log(permutation("ABC"));
console.log(permutation("A"));
console.log(permutation(""));
