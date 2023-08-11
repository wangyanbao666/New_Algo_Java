package org.example;

public class FindTheHighestAltitude_1732 {
    class Solution {
        public int largestAltitude(int[] gain) {
            int r = Math.max(0,gain[0]);
            for (int i=1;i<gain.length;i++){
                gain[i] = gain[i-1]+gain[i];
                r = Math.max(gain[i], r);
            }
            return r;
        }
    }
}
