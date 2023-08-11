package org.example;

public class MaxScoreAfterNOperations_1799 {
    static class Solution {
        public int maxScore(int[] nums) {
            int[][] pairs = new int[nums.length][nums.length];
            int[][] dp = new int[nums.length][1<<(nums.length+1)];
            for (int i=0;i<nums.length;i++){
                for (int j=i+1;j<nums.length;j++){
                    pairs[i][j] = gcd(nums[i], nums[j]);
                }
            }

            return dfs(dp, 0, 0, nums.length/2, pairs);
        }

        public int gcd(int a, int b){
            while (a%b!=0){
                int lastB = b;
                b = a%b;
                a = lastB;
            }
            return b;
        }

        public int dfs(int[][] dp, int bitmask, int i, int n, int[][] gcd){
            if (i>=n){
                return 0;
            }
            if (dp[i][bitmask] == 0){
                for (int j=0;j<2*n;j++){
                    if ((bitmask&1<<j)!=0){
                        continue;
                    }
                    for (int k=j+1;k<2*n;k++){
                        if ((bitmask&1<<k)!=0){
                            continue;
                        }
                        int newBitmask = bitmask+(1<<j)+(1<<k);
                        dp[i][bitmask] = Math.max(dp[i][bitmask], dfs(dp,newBitmask,i+1,n,gcd)+(i+1)*gcd[j][k]);
                    }
                }
            }

            return dp[i][bitmask];
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxScore(new int[]{109497,983516,698308,409009,310455,528595,524079,18036,341150,641864,913962,421869,943382,295019}));
    }
}
