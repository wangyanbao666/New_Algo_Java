package org.example;

import java.util.*;

public class TopKFrequentElements_347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] result = new int[k];
            HashMap<Integer, Integer> freq = new HashMap<>();
            Arrays.stream(nums).forEach(i -> {
                freq.putIfAbsent(i,0);
                freq.put(i,freq.get(i)+1);
            });
            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freq.entrySet());
            entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if  (o1.getValue() > o2.getValue()){
                        return 1;
                    } else if (o1.getValue() == o2.getValue()) {
                        return 0;
                    }
                    else {
                        return -1;
                    }
                }
            });
            Collections.reverse(entryList);
            for (int i=0;i<k;i++){
                result[i] = entryList.get(i).getKey();
            }
            return result;
        }
    }
}
