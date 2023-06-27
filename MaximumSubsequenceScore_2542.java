package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class MaximumSubsequenceScore_2542 {
    class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            Arrays.sort(nums1);
            List<int[]> paris = new ArrayList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
            for (int i=0;i<nums1.length;i++){
                paris.add(new int[]{nums1[i],nums2[i]});
            }
            paris.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return 0;
                    }
                    return o1[1] < o2[1] ? 1 : -1;
                }
            });
            int res = 0;
            int partialSum = 0;
            int cur;

            for (int[] pari: paris){
                System.out.println(Arrays.toString(pari));
            }
            for (int i=0;i<nums1.length;i++){
                if (priorityQueue.size() == k){
                    partialSum -= priorityQueue.poll();
                }
                priorityQueue.add(paris.get(i)[0]);
                partialSum += paris.get(i)[0];
                cur = partialSum*paris.get(i)[1];
                if (cur>res){
                    res = cur;
                }

            }
            return res;
        }
    }
}
