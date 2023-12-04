var assert = require('assert');
var uniquePaths = function(m, n) {
    return getTotalPath(m,n,0,0);
};

const visited = {}

function getTotalPath(m, n, row_index, col_index) {
    if(row_index>=m || col_index>=n) {
        return 0;
    }
    let key = row_index + " " + col_index;
    if(visited[key]) {
        return visited[key];
    }
    const rightPathCount = getTotalPath(m,n,row_index+1,col_index);
    const bottomPathCount = getTotalPath(m,n,row_index,col_index+1);
    visited[key] = rightPathCount + bottomPathCount;
	return Math.max(1, rightPathCount + bottomPathCount);
}

assert(28 == uniquePaths(7,3));
