package org.example;

import java.util.Arrays;

public class RearrangeArrayBySign_2149 {
    static class Solution {
        public int[] rearrangeArray(int[] nums) {
            int[] neg = new int[nums.length];
            int[] pos = new int[nums.length];
            int i=0;
            int j=0;
            for (int k=0;k<nums.length;k++){
                if (nums[k]<0){
                    neg[i] = nums[k];
                    i++;
                }
                else {
                    pos[j] = nums[k];
                    j++;
                }
            }
            int[] result = new int[nums.length];
            for (int k=0;k<nums.length/2;k++){
                result[2*k] = pos[k];
                result[2*k+1] = neg[k];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }
}
