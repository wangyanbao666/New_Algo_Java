package org.example;

import java.util.Arrays;

public class LongestSubsequence {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int result = 0;
            int[] array = new int[nums.length];

            for (int num : nums) {
                int i = 0;
                int j = result;
                while (i<j){
                    int n = (i+j)/2;
                    if (array[n]<num){
                        i = n + 1;
                    }
                    else {
                        j = n;
                    }
                }
                array[i] = num;
                if (i == result){
                    result++;
                }

            }
            return result;
        }
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,4}));
    }
}
