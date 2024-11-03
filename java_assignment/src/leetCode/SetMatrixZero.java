package leetCode;
// 73. Set Matrix Zeroes
//https://leetcode.com/problems/set-matrix-zeroes/description/
public class SetMatrixZero {

}


class Solution {
    public void setZeroes(int[][] matrix) {
        int col1 = 1;
        int row1 = 1;
        for ( int i = 0; i < matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                if( matrix[i][j] == 0) {

                    if (i == 0) row1 = 0;
              if (j == 0) col1 = 0;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
                
                }
            }
        }

        // 
        for ( int i = 1; i < matrix.length; i++) {
            for(int j = 1; j< matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    if ((matrix[i][0] == 0) || matrix[0][j] == 0 ){
                         matrix[i][j]  = 0;
                    }
                }
            }
        }

        if(row1 == 0) {
            for(int j = 0; j< matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        
           if(col1 == 0) {
            for(int i = 0; i< matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        å
    }
}