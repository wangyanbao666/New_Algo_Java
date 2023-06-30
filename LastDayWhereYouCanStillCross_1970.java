package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LastDayWhereYouCanStillCross_1970 {
    class Solution {
        public int latestDayToCross(int row, int col, int[][] cells) {
            int l=0;
            int r=cells.length;
            while (l<r){
                int n=l+(r-l)/2;
                if (checkPossible(n, cells, row, col)){
                    l=n+1;
                    // System.out.println(l+" "+r);
                }
                else {
                    r=n;
                }
            }
            return l-1;
        }

        public boolean checkPossible(int day, int[][] cells, int row, int col){
            int[][] matrix = new int[row][col];
            int[][] visited = new int[row][col];
            for (int cur=0;cur<day;cur++){
                int[] pos = cells[cur];
                matrix[pos[0]-1][pos[1]-1] = 1;
            }
            List<int[]> queue = new LinkedList<>();
            for (int i=0;i<col;i++){
                if (matrix[0][i]==0){
                    queue.add(new int[]{0, i});
                    visited[0][i]=1;
                }
            }
            while (queue.size()>0){
                int[] pos = queue.remove(0);
                int curRow = pos[0];
                int curCol = pos[1];
                if (curRow==row-1){
                    return true;
                }
                if (curCol>0){
                    if (matrix[curRow][curCol-1]==0){
                        if (visited[curRow][curCol-1]==0){
                            visited[curRow][curCol-1]=1;
                            queue.add(new int[]{curRow, curCol-1});
                        }
                    }
                }
                if (curRow<row-1){
                    if (matrix[curRow+1][curCol]==0){
                        if (visited[curRow+1][curCol]==0){
                            visited[curRow+1][curCol]=1;
                            queue.add(new int[]{curRow+1, curCol});
                        }
                    }
                }
                if (curRow>0){
                    if (matrix[curRow-1][curCol]==0){
                        if (visited[curRow-1][curCol]==0){
                            visited[curRow-1][curCol]=1;
                            queue.add(new int[]{curRow-1, curCol});
                        }
                    }
                }
                if (curCol<col-1){
                    if (matrix[curRow][curCol+1]==0){
                        if (visited[curRow][curCol+1]==0){
                            visited[curRow][curCol+1]=1;
                            queue.add(new int[]{curRow, curCol+1});
                        }
                    }
                }

            }
            return false;
        }
    }
}
