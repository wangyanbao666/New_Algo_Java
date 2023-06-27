package org.example;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence_1502 {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int interval = arr[1]-arr[0];
            for (int i=1;i<arr.length-1;i++){
                if (interval!=arr[i+1]-arr[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
