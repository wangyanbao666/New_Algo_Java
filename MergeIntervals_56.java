package org.example;

import java.util.*;

public class MergeIntervals_56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> result = new ArrayList();
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0]>o2[0]){
                        return 1;
                    }
                    else if (o1[0]==o2[0]){
                        return 0;
                    }
                    else {
                        return -1;
                    }
                }
            });
            for (int i=0;i<intervals.length;i++){
                if (result.size()==0){
                    System.out.println(Arrays.toString(intervals[i]));
                    result.add(intervals[i]);
                }
                else {
                    int[] last = result.get(result.size()-1);
                    if (last[1]>=intervals[i][0]){
                        last[1] = Math.max(intervals[i][1], last[1]);
                    }
                    else {
                        result.add(intervals[i]);
                    }
                }
            }
            int[][] resultConverted = new int[result.size()][];
            for (int i=0;i<result.size();i++){
                resultConverted[i] = result.get(i);
            }
            return resultConverted;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 4},{0,4}})));
    }
}
