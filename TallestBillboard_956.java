package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TallestBillboard_956 {
    class Solution {
        public int tallestBillboard(int[] rods) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,0);
            for (int i=0;i<rods.length;i++){
                HashMap<Integer, Integer> newMap = (HashMap<Integer, Integer>) map.clone();
                Set<Map.Entry<Integer, Integer>> set = map.entrySet();
                for (Map.Entry<Integer, Integer> entry: set){
//                    add to taller
                    int t1 = newMap.getOrDefault(entry.getKey()+rods[i],0);
                    newMap.put(entry.getKey()+rods[i], Math.max(entry.getValue()+rods[i], t1));
//                    all to shorter
                    int t2 = newMap.getOrDefault(Math.abs(entry.getKey()-rods[i]),0);
                    newMap.put(Math.abs(entry.getKey()-rods[i]), Math.max(Math.max(entry.getValue()+rods[i]- entry.getKey(), t2), entry.getValue()));
                }
                map = newMap;
            }
            return map.get(0);
        }

        public HashMap<Integer, Integer> cloneMap(HashMap<Integer, Integer> map){
            HashMap<Integer, Integer> newMap = new HashMap<>();
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            for (Map.Entry<Integer, Integer> entry: set){
                newMap.put(entry.getKey(),entry.getValue());
            }
            return newMap;
        }
    }
}
