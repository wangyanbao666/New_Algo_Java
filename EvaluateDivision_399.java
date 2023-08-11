package org.example;

import java.util.*;

public class EvaluateDivision_399 {
    static class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            HashMap<String, HashMap<String, Double>> map = new HashMap<>();
            for (int i=0;i<equations.size();i++){
                String u = equations.get(i).get(0);
                String v = equations.get(i).get(1);
                double value = values[i];
                map.computeIfAbsent(u, k -> new HashMap<>());
                map.get(u).put(v,value);
                map.computeIfAbsent(v, k -> new HashMap<>());
                map.get(v).put(u, 1/value);
            }

            double[] result = new double[queries.size()];
            HashSet visited;
            for (int i=0;i<queries.size();i++){
                visited = new HashSet();
                String start = queries.get(i).get(0);
                visited.add(start);
                String end = queries.get(i).get(1);
                result[i] = dfs(map, start, end, visited);
            }

            return result;
        }

        public double dfs(HashMap<String, HashMap<String, Double>> map, String start, String to,  HashSet<String> visited){
            if (map.get(start)==null){
                return -1;
            }
            double cost = 1;
            HashMap<String, Double> children = map.get(start);
            if (children.containsKey(to)){
                return children.get(to);
            }
            for (Map.Entry<String, Double> entry : children.entrySet()) {
                String v = entry.getKey();
                Double value = entry.getValue();
                if (!visited.contains(v)) {
                    visited.add(v);
                    cost*=value;
                    double valid = dfs(map, v, to, visited);
                    if (valid > 0) {
                        cost *= valid;
                        return cost;
                    }
                    cost/=value;
                }
            }
            return -1;
        }
    }
}
