package org.example;

import java.util.*;

public class PathWithMaximumProbability_1514 {
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            double[] dist = new double[n];
            dist[start]=1;
            PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>() {
                @Override
                public int compare(double[] o1, double[] o2) {
                    if (o1[1]==o2[1] ){
                        return 0;
                    }
                    return o2[1]>o1[1] ? 1 : -1;
                }
            });
            Map<Integer, Double>[] map = new Map[n];
            for (int i = 0; i < n; i++) {
                map[i] = new HashMap<>();
            }
            for (int i=0; i<edges.length;i++){
                int[] edge = edges[i];
                map[edge[0]].put(edge[1], succProb[i]);
                map[edge[1]].put(edge[0], succProb[i]);
            }
//            Set<Integer> set = new HashSet<>();

            queue.offer(new double[]{start, 1});

//            set.remove(start);
            while (queue.size()>0){
                double[] idx = queue.poll();
                if (idx[0] == end){
                    return dist[end];
                }
                Map<Integer, Double> dest = map[(int) idx[0]];
                if (dest!=null){
                    Set<Map.Entry<Integer, Double>> set = dest.entrySet();
                    for (Map.Entry<Integer, Double> d:set){
                        double newDist = d.getValue()*dist[(int) idx[0]];
                        if (newDist>dist[d.getKey()]){
                            dist[d.getKey()] = newDist;
                            queue.offer(new double[]{d.getKey(),newDist});
                        }
                    }
                }
            }
            return 0;
        }
    }
}
