print = console.log;
x =[[1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1],
	[0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0],
	[0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0],
	[1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0]];

// left bottom right

function count(array2d, i, j) {
	if (i < 0 || j < 0 || j == array2d[0].length || i == array2d.length) {
		return 0;
	}
	if(array2d[i][j] == 0){
		return 0;
	}

	if(array2d[i][j] == 1){
		array2d[i][j] = 0;
		let left = count(array2d, i, j - 1);
		let up = count(array2d, i - 1, j);
		let bottom = count(array2d, i + 1, j);
		let right = count(array2d, i, j + 1);
		let leftLowerDiagonal = count(array2d, i + 1, j - 1);
		let rightLowerDiagonal = count(array2d, i + 1, j + 1);
		let leftUpperDiagonal = count(array2d, i - 1, j - 1);
		let rightUpperDiagonal = count(array2d, i - 1, j + 1);
		return 1 + left + leftLowerDiagonal + bottom + rightLowerDiagonal + right + rightUpperDiagonal + up + leftUpperDiagonal;
	}
}


function main() {
	max = 0;
	array2d = x
	for (var i = 0; i < array2d.length; i++) {
		for (var j = 0; j < array2d[i].length; j++) {
			if(array2d[i][j] == 1){
				let currentSize = count(array2d, i,j)
				max = max > currentSize ? max : currentSize;
			}
		}
	}
	print(max);
}

main()

// 1 + 0 + 0 + ----			i 0 j 1
// 1 + 0 + 0 + ----			i 0 j 2 
