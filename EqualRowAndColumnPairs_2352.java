package org.example;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class EqualRowAndColumnPairs_2352 {
    class Solution {
        public int equalPairs(int[][] grid) {
            HashMap<String,Integer> row = new HashMap<>();
            HashMap<String, Integer> col = new HashMap<>();
            int result = 0;
            for (int[] value : grid) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < grid[0].length; j++) {
                    s.append(value[j]);
                }
                row.putIfAbsent(s.toString(), 0);
                row.put(s.toString(), row.get(s.toString())+1);
            }

            for (int i=0;i<grid[0].length;i++){
                StringBuilder s = new StringBuilder();
                for (int[] ints : grid) {
                    s.append(ints[i]);
                }
                col.putIfAbsent(s.toString(), 0);
                col.put(s.toString(), col.get(s.toString())+1);
            }
            Set<Map.Entry<String, Integer>> set = row.entrySet();
            for (Map.Entry<String, Integer> entry: set){
                String key = entry.getKey();
                if (col.containsKey(key)){
                    result += entry.getValue()*col.get(key);
                }
            }
            return result;
        }
    }
}
