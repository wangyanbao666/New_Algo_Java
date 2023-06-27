package org.example;

public class NumberOfProvinces_547 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int[] visited = new int[isConnected.length];
            int result = 0;
            for (int i=0;i<isConnected.length;i++){
                if (visited[i]==0){
                    result++;
                    visited[i] = 1;
                    dfs(isConnected, visited, i);
                }
            }
            return result;
        }

        public void dfs(int[][] isConnected, int[] visited, int idx){
            int[] connected = isConnected[idx];
            for (int i=0;i<connected.length;i++){
                if (visited[i] == 0 && connected[i] == 1){
                    visited[i] = 1;
                    dfs(isConnected, visited, i);
                }
            }
        }
    }
}
