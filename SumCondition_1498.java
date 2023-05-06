package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class SumCondition_1498 {
    static class Solution {
        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);
            int max = nums[nums.length-1];
            int min;
            int j = nums.length-1;
            int result = 0;
            int mod = 1000000007;
            List<Integer> pre = new ArrayList<>();
            pre.add(1);
            for (int i = 1; i <= nums.length; ++i) {
                pre.add((pre.get(i - 1) << 1) % mod);
            }
            for (int i=0;i<nums.length;i++){
                min = nums[i];
                while (j>=0 && max+min>target){
                    j--;
                    if (j>0){
                        max = nums[j];
                    }
                }
//                System.out.printf("%d,%d\n",j,i);
                if (j<i){
                    break;
                }
                result = (result+pre.get(j-i))%mod;

            }
            return result;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSubseq(new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14},22));
    }
}
