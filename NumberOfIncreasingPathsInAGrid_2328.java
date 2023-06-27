package org.example;

import java.util.Arrays;

public class NumberOfIncreasingPathsInAGrid_2328 {
    class Solution {
        public int countPaths(int[][] grid) {
            int[][] memo = new int[grid.length][grid[0].length];
            int[][] visited = new int[grid.length][grid[0].length];
            for (int[] row: memo){
                Arrays.fill(row, 1);
            }
            int result = 0;
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (visited[i][j]==0){
                        dfs(memo, visited, i, j);
                    }
                    System.out.println(memo[i][j]);
                    result += memo[i][j];
                }
            }
            return result;

        }

        public int dfs(int[][] memo, int[][] visited, int i, int j){
            int result = 1;
            if (visited[i][j] == 1){
                return memo[i][j];
            }
            if (i>0 && memo[i-1][j]<memo[i][j]){
                result += dfs(memo, visited, i-1, j);
            }
            if (i< memo.length-1 && memo[i+1][j]<memo[i][j]){
                result += dfs(memo, visited, i+1, j);
            }
            if (j>0 && memo[i][j-1]<memo[i][j]){
                result += dfs(memo, visited, i, j-1);
            }
            if (j< memo[0].length-1 && memo[i][j+1]<memo[i][j]){
                result += dfs(memo, visited, i, j+1);
            }
            memo[i][j] = result;
            visited[i][j] = 1;
            return memo[i][j];
        }
    }
}
