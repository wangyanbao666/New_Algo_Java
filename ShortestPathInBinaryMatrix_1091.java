package org.example;

import java.util.ArrayList;

public class ShortestPathInBinaryMatrix_1091 {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0]==1){
                return -1;
            }
            int[][] visited = new int[grid.length][grid[0].length];
            int count = 1;
            ArrayList<int[]> queue = new ArrayList<>();
            queue.add(new int[]{0,0});
            visited[0][0] = 1;
            while (queue.size()>0){
                ArrayList<int[]> newQueue = new ArrayList<>();
                while (queue.size()>0){
                    int[] index = queue.remove(0);
                    if (index[0] == grid.length-1 && index[1] == grid[0].length-1){
                        return count;
                    }
                    for (int i=-1;i<=1;i++){
                        int first = i+index[0];
                        if (first>=0 && first<grid.length){
                            for (int j=-1;j<=1;j++){
                                int second = j+index[1];
                                if (second>=0 && second<grid[0].length){
                                    if (visited[first][second]==0 && grid[first][second]==0){
                                        visited[first][second] = 1;
                                        newQueue.add(new int[]{first, second});
                                    }
                                }
                            }
                        }
                    }
                }
                queue = newQueue;
                count++;
            }
            return -1;
        }
    }
}
