package org.example;

import java.util.ArrayList;

public class Dota2Senta_76 {
    static class Solution {
        public String predictPartyVictory(String senate) {
            ArrayList<Integer> queueR = new ArrayList();
            ArrayList<Integer> queueD = new ArrayList();
            int l = senate.length();
            for (int i=0;i<senate.length();i++){
                if (senate.charAt(i) == 'R'){
                    queueR.add(i);
                }
                else {
                    queueD.add(i);
                }

            }
            while (queueR.size() > 0 && queueD.size() > 0){
                if (queueR.get(0) > queueD.get(0)){
                    queueR.remove(0);
                    int D = queueD.remove(0) + l;
                    queueD.add(D);
                }
                else {
                    queueD.remove(0);
                    int R = queueR.remove(0) + l;
                    queueR.add(R);
                }
            }
            if (queueD.size() == 0){
                return "Radiant";
            }
            return "Dire";
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.predictPartyVictory("RDD"));
    }
}
