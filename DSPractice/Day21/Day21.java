import java.util.*;

/**
 * Day21
 */
public class Day21 {
    public static void main(String[] args) {
        Day21 day21 = new Day21();
        int[][] input = { { 1, 1, 1, 1, 0, 0, 0 }, 
                          { 1, 1, 0, 0, 0, 0, 0 },
                          { 1, 1, 1, 0, 0, 0, 0 },
                          { 1, 1, 1, 1, 1, 1, 0 }, 
                          { 1, 1, 1, 0, 0, 0, 0 } };
        int[][] input1 = {{ 0, 0, 0, 0, 0, 0, 0 }};                  
        System.out.println(day21.getRowWithLargest1(input));
        System.out.println(day21.getRowWithLargest1(input1));

        System.out.println();
    }

    private int getRowWithLargest1(int[][] input) {
        int row = input.length;
        int col = input[0].length;
        int col_index = 0;
        int row_index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = col_index; j < col; j++) {
                if(j == col_index && input[i][j] == 0)
                    break;
                if(input[i][j] == 0){
                    col_index = j;
                    break;
                }
                row_index = i+1;
            }
        }
        return row_index;
    }

}