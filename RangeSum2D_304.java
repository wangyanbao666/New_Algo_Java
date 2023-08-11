package org.example;

import java.util.Arrays;

public class RangeSum2D_304 {
    class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length+1][matrix[0].length+1];
            for (int i=1;i<matrix.length+1;i++){
                for (int j=1;j<matrix[0].length+1;j++){
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2+1][col2+1] + sum[row1][col1] - sum[row1][col2+1] - sum[row2+1][col1];
        }
    }
}
