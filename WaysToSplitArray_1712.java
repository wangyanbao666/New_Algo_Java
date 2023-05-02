package org.example;

import java.util.Arrays;

public class WaysToSplitArray_1712 {
    class Solution {
        public int waysToSplit(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int th = sum/3;
            int th2 = sum/3*2;
            int num = 0;
            int lowSum = 0;
            int lowI = 0;
            int midSum = 0;
            int midI = 0;
            for (int i=0;i<nums.length;i++){
                lowSum += nums[i];
                if (lowSum > th) {
                    break;
                }
            }
            return 0;
        }
    }
}
