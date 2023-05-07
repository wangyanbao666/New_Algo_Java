package org.example;

import java.util.*;

public class CarPooling_1094 {
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
            List<Integer> qStart = new LinkedList<Integer>();
            List<Integer> qStartNum = new LinkedList<Integer>();
            List<Integer> qEnd = new LinkedList<Integer>();
            List<Integer> qEndNum = new LinkedList<Integer>();
            for (int i=0;i<trips.length;i++){
                qStartNum.add(trips[i][0]);
                qStart.add(trips[i][1]);
            }
            Arrays.sort(trips, Comparator.comparingInt(a -> a[2]));
            for (int i=0;i<trips.length;i++){
                qEndNum.add(trips[i][0]);
                qEnd.add(trips[i][2]);
            }
            int cur = 0;
            while (qStart.size()>0){
                int start = qStart.remove(0);
                int add = qStartNum.remove(0);
                while (qEnd.size()>0 && start>= qEnd.get(0)){
                    qEnd.remove(0);
                    int remove = qEndNum.remove(0);
                    cur-=remove;
                }
                cur+=add;
                if (cur>capacity){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.carPooling(new int[][]{{9,3,4},{9,1,7},{4,2,4},{7,4,5}},23));
    }
}
