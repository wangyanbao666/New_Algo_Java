package org.example;

public class JumpGameII_45 {
    class Solution {
//        public int jump(int[] nums) {
//            int[] memo = new int[nums.length];
//            for (int i=0;i<nums.length-1;i++){
//                int jump = nums[i];
//                for (int j=i+1;j<=i+jump;j++){
//                    int count = memo[i] + 1;
//                    if (memo[j]<0){
//                        memo[j] = count;
//                    }
//                    else {
//                        memo[j] = Math.min(count,memo[j]);
//                    }
//                }
//            }
//            return memo[nums.length-1];
//        }

        public int jump(int[] nums) {
            int count = 0;
            int maxDist = nums[0];
            int i=0;
            while (i<nums.length-1){
                if (maxDist>=nums.length-i){
                    count++;
                    return count;
                }
                int temp = 0;
                for (;i<maxDist;i++){
                    temp = Math.max(temp, nums[i]);
                }
                count++;
                maxDist+=temp;
            }
            return count;
        }
    }
}
