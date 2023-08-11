package org.example;

public class StoneGame2_1140 {
    class Solution {
        public int stoneGameII(int[] piles) {
            int[] sums = piles.clone();
            for (int i=piles.length-2;i>=0;i--){
                sums[i] += sums[i+1];
            }
            int[][] memo = new int[piles.length+1][piles.length];
            return dp(sums, memo, 0, piles.length+1, 1);
        }
        public int dp(int[] sums, int[][] memo, int i, int n, int m){
            if (memo[i][m]>0){
                return memo[i][m];
            }
            if (n-i-1<=2*m){
                return sums[i];
            }
            int min = Integer.MIN_VALUE;
            for (int k=1;k<=2*m;k++){
                int temp = dp(sums, memo, i+k, n, Math.max(m, 2*k));
                if (temp<min){
                    min = temp;
                }
            }
            int result = sums[i] - min;
            memo[i][m] = result;
            return result;
        }
    }
}
