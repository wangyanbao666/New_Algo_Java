package org.example;

public class UncrossedLines_1035 {
    static class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] memo = new int[nums1.length+1][nums2.length+1];
            for (int i=1;i<nums1.length+1;i++){
                for (int j=1;j<nums2.length+1;j++){
                    if (nums1[i-1]==nums2[j-1]){
                        memo[i][j] = memo[i-1][j-1]+1;
                    }
                    else {
                        memo[i][j] = Math.max(memo[i-1][j],memo[i][j-1]);
                    }
                }
            }
            return memo[nums1.length][nums2.length];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
    }
}
