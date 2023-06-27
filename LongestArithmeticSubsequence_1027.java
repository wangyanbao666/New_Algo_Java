package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// if max int is small, a map can be replaced by a 2d array.
public class LongestArithmeticSubsequence_1027 {
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num: nums){
                if (num>max){
                    max = num;
                }
            }
            int[][] map = new int[nums.length][max*2+2];
            for (int i=0;i<nums.length;i++){
                Arrays.fill(map[i],1);
            }
            int result=0;
            for (int i=1;i<nums.length;i++){
                for (int j=0;j<i;j++){
                    int d = nums[i]-nums[j];
                    map[i][d+max] = map[j][d+max]+1;
                    if (map[i][d+max]>result){
                        result=map[i][d+max];
                    }
                }
            }
            return result;
        }
    }
}
