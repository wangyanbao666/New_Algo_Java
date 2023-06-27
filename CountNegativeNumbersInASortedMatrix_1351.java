package org.example;

public class CountNegativeNumbersInASortedMatrix_1351 {
    class Solution {
        public int countNegatives(int[][] grid) {
            int total = 0;
            for (int i=0;i<grid.length;i++){
                int l = 0;
                int r = grid[0].length;
                while (l<r){
                    int n = l+(r-l)/2;
                    if ((n==0 || grid[i][n-1]>=0) && grid[i][n]<0){
                        total+=grid[0].length-n;
                        break;
                    }
                    else if (grid[i][n]>=0){
                        l = n + 1;
                    }
                    else {
                        r = n;
                    }
                }
            }
            return total;

        }
    }
}
