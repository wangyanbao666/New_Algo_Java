package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers_2462 {
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(
                    (a,b) -> (costs[a] - costs[b] != 0 ? costs[a] - costs[b] : a - b)
            );
            int i = candidates;
            int j = costs.length-candidates;
            int result = 0;
            for (int l=0;l<candidates;l++){
                queue.add(l);
            }
            for (int r=0;r<Math.min(candidates,costs.length-candidates);r++){
                queue.add(costs.length-1-r);
            }
            System.out.println(queue);
            for (int w=0;w<k;w++){
                int idx = queue.poll();
                if (i<=j){
                    if (idx<i){
                        queue.add(i);
                        i++;
                    }
                    else {
                        queue.add(j);
                        j--;
                    }
                }
                result+=costs[idx];
            }
            return result;
        }

        public void insert(int val, List<Integer> vals){
            int l=0;
            int r=vals.size();
            while (l<r){
                int n = l+(r-l)/2;
                int mid = vals.get(n);
                if (val==mid){
                    vals.add(n+1, val);
                    return;
                }
                if (val>mid){
                    l=n+1;
                }
                else {
                    r=n;
                }
            }
            vals.add(l,val);
        }
    }
}
