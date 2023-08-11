package org.example;

import java.util.Arrays;

public class WaysToSplitArray_1712 {
    static class Solution {
        public int waysToSplit(int[] nums) {
            int[] sums = new int[nums.length];
            int curSum = 0;
            for (int i=0;i<nums.length;i++){
                curSum += nums[i];
                sums[i] = curSum;
            }
            int i;
            int jL=0;
            int jH=0;
            int result=0;
            for (i=0;i<sums.length-2;i++){
                while (jL< nums.length){
                    if (sums[jL] < 2*sums[i] || jL<=i){
                        jL++;
                    }
                    else {
                        break;
                    }
                }

                while (jH< nums.length){
                    if (sums[nums.length-1]-sums[jH]>=sums[jH]-sums[i] || jH<jL){
                        jH++;
                    }
                    else {
                        break;
                    }
                }
//                if (sums[nums.length-1]-sums[jH]<sums[jH]-sums[i]){
//                    break;
//                }
                result += jH-jL;
//                System.out.printf("%d, %d\n", jL, jH);
            }

            return (int) (result%(Math.pow(10,9)+7));
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.waysToSplit(new int[]{8892,2631,7212,1188,6580,1690,5950,7425,8787,4361,9849,4063,9496,9140,9986,1058,2734,6961,8855,2567,7683,4770,40,850,72,2285,9328,6794,8632,9163,3928,6962,6545,6920,926,8885,1570,4454,6876,7447,8264,3123,2980,7276,470,8736,3153,3924,3129,7136,1739,1354,661,1309,6231,9890,58,4623,3555,3100,3437}));
        System.out.println(s.waysToSplit(new int[]{1,2,2,2,5,0}));
    }
}
