package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TimeNeededToInformAllEmployees_1376 {
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int result = 0;
            int[] timeTaken = new int[manager.length];

            for (int i=0;i<manager.length;i++){
                result = Math.max(result, dfs(i, manager, informTime, timeTaken));
            }
            return result;
        }
        private int dfs(int cur, int[] manager, int[] informTime, int[] timeTaken){
            if (manager[cur] == -1){
                return 0;
            }
            if (timeTaken[cur] != 0){
                return timeTaken[cur];
            }
            int managerId = manager[cur];
            timeTaken[cur] = informTime[managerId] + dfs(managerId, manager, informTime, timeTaken);
            return timeTaken[cur];
        }
    }

}
