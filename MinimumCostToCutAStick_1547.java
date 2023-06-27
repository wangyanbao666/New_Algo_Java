package org.example;

import java.util.Arrays;

public class MinimumCostToCutAStick_1547 {
    class Solution {
        public int minCost(int n, int[] cuts) {
            int[] newCuts = new int[cuts.length+2];
            Arrays.sort(cuts);
            System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
            newCuts[cuts.length+1] = n;
            Arrays.sort(cuts);
            int[][] memo = new int[cuts.length+2][cuts.length+2];
            return dp(memo, newCuts, 0, cuts.length+1);
        }
        public int dp(int[][] memo, int[] cuts, int lIdx, int rIdx){
            if (memo[lIdx][rIdx] != 0){
                return memo[lIdx][rIdx];
            }
            int cost = Integer.MAX_VALUE;
            int temp = 0;
            for (int i=lIdx+1;i<rIdx;i++){
                temp = dp(memo, cuts, lIdx, i) + dp(memo, cuts, i, rIdx) + cuts[rIdx] - cuts[lIdx];
                if (temp<cost){
                    cost = temp;
                }
            }
            if (temp == 0) {
                cost = 0;
            }
            memo[lIdx][rIdx] = cost;
            System.out.println("l index: "+lIdx+" r index: "+rIdx+" cost: "+cost);
            return cost;
        }
    }
}
