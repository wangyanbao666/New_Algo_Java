package org.example;

import java.util.Arrays;

public class KRadiusSubarrayAverages_2090 {
    class Solution {
        public int[] getAverages(int[] nums, int k) {
            if (k==0){
                return nums;
            }
            int[] result = new int[nums.length];
            if (2*k+1>nums.length){
                Arrays.fill(result,-1);
                return result;
            }
            long medium = 0;
            for (int i=0;i<2*k+1;i++){
                medium += nums[i];
            }
            int radius = 2*k+1;
            result[k] = (int) (medium/(radius));
            for (int i=k+1;i<nums.length;i++){
                if (i>nums.length-1-k){
                    break;
                }
                else {
                    medium = medium-nums[i-1-k]+nums[i+k];
                    result[i] = (int) (medium/(radius));                }
            }
            return result;
        }
    }
}
