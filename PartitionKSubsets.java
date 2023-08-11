package org.example;

import java.util.Arrays;

public class PartitionKSubsets {
    static class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int[] visited = new int[nums.length];
            int total = 0;
            for (int i=0; i<nums.length; i++){
                total += nums[i];
            }
            if (total % k != 0){
                return false;
            }
            else{
                int partitionSum = total / k;
                Arrays.sort(nums);
                int mid = (nums.length) / 2;
                for (int l=0;l<mid;l++){
                    int temp = nums[l];
                    nums[l] = nums[nums.length-1-l];
                    nums[nums.length-1-l] = temp;
                }
                return checkPossible(visited, partitionSum, nums, k, partitionSum, 0);
            }
        }

        private boolean checkPossible(int[] visited, int left, int[] nums, int times, int standard, int nextIndex){
            if (times == 1){
                return true;
            }
//            if (left<0){
//                return false;
//            }
            if (left == 0){
                return checkPossible(visited, standard, nums, times-1, standard, 0);
            }

            boolean flag;
            for (int j=nextIndex; j<visited.length;j++){
                if (visited[j] != 1){
                    if (left-nums[j]<0 || (j>0 && nums[j]==nums[j-1])){
                        continue;
                    }
                    visited[j] = 1;
                    flag = checkPossible(visited, left-nums[j], nums, times, standard, j+1);
                    if (flag){
                        return true;
                    }
                    visited[j] = 0;
                }

            }
            return false;

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,2,2,2,2};
        int k = 4;
        Solution s = new Solution();
        System.out.println(s.canPartitionKSubsets(nums, k));
    }

}
