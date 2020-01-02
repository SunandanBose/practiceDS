

public class NQueen
{
	public static void main(String[] args) {
		int n = 4;
		boolean flag = false;
		int[][] board = new int[n][n];
		placeNQueen(n,board);
		print(board);
	}
	private static void print(int[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++)
				System.out.print(board[i][j]+ "\t");
			System.out.println();
		}
	}

	private static boolean placeNQueen(int n, int[][] board){

	    if(n==0)
			return true;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j] != 1){
					board[i][j] = 1;
					if(check(i,j,board)){ 
						placeNQueen(n--,board);
					}
					else{
						board[i][j]=0;
					}
				}	
			}
		}
		return false;
	}
	private static boolean check(int _indexi, int _indexj, int[][] board){
		boolean flag = false;
		if(checkHorizontalVertical( _indexi,  _indexj, board)){
			if(checkDiagonal( _indexi,  _indexj, board))
				flag = true;
		}
		return flag;
	}

	private static boolean checkHorizontalVertical(int _indexi, int _indexj, int[][] board){
	    boolean horizontalCheck = false;
	    boolean verticalalCheck = false;
	    int horizontalCount =0 , verticalalCount = 0;
	    for(int i=0;i<board.length;i++){
	        if(board[i][_indexj] == 1 ) verticalalCount ++;
	        if(board[_indexi][i] == 1 ) horizontalCount ++;
	    }
	    if(verticalalCount <= 1 && horizontalCount <= 1) return true;
	    else return false;
	}
	
	private static boolean checkDiagonal(int i, int j, int[][] board){
		int _indexi = i;
		int _indexj = j;
		while(--_indexi>=0 && --_indexj>=0){//N-W
			if(board[_indexi][_indexj]==1){
				return false;
			}
			_indexi--;
			_indexj--;
		}
	 	_indexi = i;
		_indexj = j;
		while(--_indexi>=0 && ++_indexj<board.length){//N-E
			if(board[_indexi][_indexj]==1){
				return false;
			}
			_indexi--;
			_indexj++;
		}
		_indexi = i;
		_indexj = j;
	    while(--_indexj>=0 && ++_indexi<board.length){//S-W
			if(board[_indexi][_indexj]==1){
				return false;
			}
			_indexj--;
			_indexi++;
		}
		_indexi = i;
		_indexj = j;
		while(++_indexj<board.length && ++_indexi<board.length){//S-E
			if(board[_indexi][_indexj]==1){
				return false;
			}
			_indexj++;
			_indexi++;
		}
	    return true;
	}
}
