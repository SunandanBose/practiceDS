

class RotationMatrix{

	static void print(int[][] matrix){
		for(int i= 0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				System.out.print(matrix[i][j] + "	");
			System.out.println();
		}
	}
	static void rotateInPlace(int[][] matrixToRotate){
		int rowSize = matrixToRotate.length;
		int columnSize = matrixToRotate[0].length-1;
		int initial,temp;
		initial=0;
		while(initial<(rowSize/2)){
			for(int i=initial;i<rowSize-initial-1;i++){
				temp = matrixToRotate[initial][i];
				matrixToRotate[initial][i]=matrixToRotate[columnSize-i][initial];
				matrixToRotate[columnSize-i][initial]=matrixToRotate[columnSize-initial][columnSize-i];
				matrixToRotate[columnSize-initial][columnSize-i]=matrixToRotate[i][columnSize-initial];
				matrixToRotate[i][columnSize-initial]=temp;
			}
			initial++;
		}
		print(matrixToRotate);
	}

	static void rotate(int[][] matrixToRotate){
		int rowSize = matrixToRotate.length;
		int columnSize = matrixToRotate[0].length;
		int[][] finalMatrix = new int[columnSize][rowSize];
		for(int i=rowSize-1;i>=0;i--){
			for(int j=0;j<columnSize;j++){
				finalMatrix[j][rowSize-i-1] = matrixToRotate[i][j];
			}
		}
		print(finalMatrix);
	}

	public static void main(String args[]){
		int[][] matrix ={{1,3,2,9},{7,5,8,17},{56,21,4,14},{31,65,6,90}};
		print(matrix);
		System.out.println();
		rotateInPlace(matrix);
		System.out.println();
		int[][] matrix1 ={{1,3,2,9},{7,5,8,17},{56,21,4,14},{31,65,6,90}};
		rotate(matrix1);
	}


}




