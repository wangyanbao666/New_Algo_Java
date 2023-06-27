package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums_373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            List<List<Integer>> result = new ArrayList<>();
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (
                    a[0]+a[1]-b[0]-b[1]
                    ));
            for (int i=0;i<nums1.length;i++){
                queue.offer(new int[]{nums1[i], nums2[0], 0});
            }
            while (k>0 && queue.size()>0){
                k--;
                int[] cur = queue.poll();
                List<Integer> r = new ArrayList<>();
                r.add(cur[0]);
                r.add(cur[1]);
                result.add(r);
                if (cur[2]<nums2.length-1){
                    queue.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
                }
            }
            return result;
        }
    }
}
