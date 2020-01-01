

public class NQueen
{
	public static void main(String[] args) {
		int n = 4;
		boolean flag = false;
		int[][] board = new int[n][n];
		placeNQueen(n,0,0,board);
	}
	private static boolean placeNQueen(int n, int _indexi, int _indexj, int[][] board){
	    if(n<=0)
	        return true;
	    if(checkHorizontalVertical(_indexi,_indexj,board) && checkDiagonal(_indexi,_indexj,board)){
	        return true;
	    }
	                
	    for(int i = 0; i< n; i++ ){
	        for(int j = 0;j< n; j++){
	            board[i][j] = 1;
	            flag = placeNQueen(n,i,j,board)
	            if(!flag){
	                board[i][j] = 0;
	            }
	            else{
	                n--;
	            }
	            
	        }
	    }
	    return true;
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
	
	private static boolean checkDiagonal(int _indexi, int _indexj, int[][] board){

	    
	    return true;
	}
}
