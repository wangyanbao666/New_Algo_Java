package org.example;

import java.util.*;

public class DataStreamasDisjointIntervals_352 {
    class SummaryRanges {
        private HashMap<Integer, Integer> intervalStart;
        private HashMap<Integer, Integer> intervalEnd;
        private int[] added;
        public SummaryRanges() {
            intervalStart = new HashMap<>();
            intervalEnd= new HashMap<>();
            added = new int[10001];
        }

        public void addNum(int value) {
            if (added[value]==1){
                return;
            }
            added[value] = 1;
            if (intervalEnd.containsKey(value-1)){
                if (intervalStart.containsKey(value+1)){
                    int end = intervalStart.get(value+1);
                    int start = intervalEnd.get(value-1);
                    intervalStart.remove(value+1);
                    intervalStart.put(start, end);
                    intervalEnd.remove(value-1);
                    intervalEnd.put(end, start);
                }
                else{
                    int start = intervalEnd.get(value-1);
                    intervalEnd.remove(value-1);
                    intervalStart.put(start, value);
                    intervalEnd.put(value, start);
                }
            }
            else if (intervalStart.containsKey(value+1)){
                int end = intervalStart.get(value+1);
                intervalStart.remove(value+1);
                intervalStart.put(value, end);
                intervalEnd.put(end, value);
            }
            else {
                intervalStart.put(value, value);
                intervalEnd.put(value, value);
            }
        }

        public int[][] getIntervals() {
            ArrayList<int[]> result = new ArrayList<>();
            Map.Entry<Integer, Integer> entry;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : intervalStart.entrySet()) {
                entry = integerIntegerEntry;
                result.add(new int[]{entry.getKey(), entry.getValue()});
            }
            Collections.sort(result, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0]==o2[0]){
                        return 0;
                    }
                    return o1[0]>o2[0] ? 1: -1;
                }
            });
            System.out.println(Arrays.deepToString(result.toArray(new int[0][])));
            return result.toArray(new int[0][]);
        }
    }
}
