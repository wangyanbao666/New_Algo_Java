package org.example;

import java.util.HashMap;

public class DesignUndergroundSystem_1396 {
    class UndergroundSystem {
        HashMap<Integer, HashMap<String, String>> checkInState;
        HashMap<String, HashMap<String, double[]>> avgTime;

        public UndergroundSystem() {
            checkInState = new HashMap<>();
            avgTime = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            HashMap<String, String> info = new HashMap<>();
            info.put("start",stationName);
            info.put("time",String.valueOf(t));
            checkInState.put(id, info);
        }

        public void checkOut(int id, String stationName, int t) {
            HashMap<String, String> info = checkInState.get(id);
            int time = Integer.parseInt(info.get("time"));
            String start = info.get("start");
            if (avgTime.get(start) == null){
                HashMap<String, double[]> newHashMap =  new HashMap<>();
                avgTime.put(start, newHashMap);
            }
            if (avgTime.get(start).get(stationName) == null){
                HashMap<String, double[]> newHashMap =  avgTime.get(start);
                newHashMap.put(stationName, new double[]{0,0});
            }

            double[] arr = avgTime.get(start).get(stationName);
            double count = arr[0];
            double previous_t = arr[1];
            arr[1] = (previous_t * count + t - time)/(count+1);
            count++;
            arr[0] = count;
        }

        public double getAverageTime(String startStation, String endStation) {
            return avgTime.get(startStation).get(endStation)[1];
        }
    }
}
