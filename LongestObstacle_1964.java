package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestObstacle_1964 {
    static class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int[] result = new int[obstacles.length];
            int[] increasingSequence = new int[obstacles.length];
            int length = 0;
            for (int i=0;i<obstacles.length;i++){
                result[i] = 1;
            }
            for (int i=0;i<obstacles.length;i++){
                int l=0;
                int r=length;
                while (l<r){
                    int mid = (l+r)/2;
                    if (obstacles[i]>=increasingSequence[mid]){
                        l=mid+1;
                    }
                    else {
                        r=mid;
                    }
                }
                if (l+1>length){
                    length = l+1;
                }
                increasingSequence[l]=obstacles[i];
                result[i] = l+1;

            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2})));
    }
}
