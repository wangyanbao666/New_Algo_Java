package org.example;

import java.util.Arrays;

public class StoneGame3_1406 {
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int[] sums = stoneValue.clone();
            for (int i=sums.length-2;i>=0;i--){
                sums[i] += sums[i+1];
            }
            int total = sums[0];
            int[] memo = new int[sums.length];
            Arrays.fill(memo, Integer.MAX_VALUE);
            memo[memo.length-1] = sums[sums.length-1];
            int scoreAlice = dp(memo, sums, 0, stoneValue.length);
            System.out.println(scoreAlice);
            if (total-scoreAlice>scoreAlice){
                return "Bob";
            }
            else if (total-scoreAlice==scoreAlice){
                return "Tie";
            }
            else {
                return "Alice";
            }
        }

        public int dp(int[] memo, int[] sums, int i, int n){
            if (memo[i]!=Integer.MAX_VALUE){
                return memo[i];
            }
            int min = Integer.MAX_VALUE;
            for (int k=1;k<=3;k++){
                if (i+k<n-1){
                    int temp = dp(memo, sums, i+k, n);
                    if (temp<min){
                        min = temp;
                    }
                }
            }
            memo[i] = sums[i] - min;
            return memo[i];
        }
    }
}
