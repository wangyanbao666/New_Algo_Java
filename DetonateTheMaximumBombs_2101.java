package org.example;

public class DetonateTheMaximumBombs_2101 {
    class Solution {
        public int maximumDetonation(int[][] bombs) {
//            int[] memo = new int[bombs.length];
            int result = 0;
            for (int i=0;i<bombs.length;i++){
                int[] visited = new int[bombs.length];
                visited[i] = 1;
                result = Math.max(result, dfs(bombs[i], bombs, i, visited));
            }
            return result;

        }

        private int dfs(int[] bomb, int[][] bombs, int i, int[] visited){
            int count = 1;
            for (int j=0;j<bombs.length;j++){
                if (visited[j] != 1){
                    if (checkIn(bomb, bombs[j])){
                        visited[j] = 1;
                        count += dfs(bombs[j], bombs, j, visited);
                    }
                }
            }
            return count;

        }

        private boolean checkIn(int[] bomb1, int[] bomb2){
            return Math.sqrt((bomb1[0]-bomb2[0])*(bomb1[0]-bomb2[0])+(bomb1[1]-bomb2[1])*(bomb1[1]-bomb2[1]))<=bomb1[2];
        }
    }
}
