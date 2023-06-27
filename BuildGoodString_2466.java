package org.example;

import java.util.HashMap;

public class BuildGoodString_2466 {
    static class Solution {
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] memo = new int[high+1];
            memo[0] = 1;
            int max = Math.max(zero, one);
            int min = Math.min(zero, one);

            memo[min] = 1;
            if (max%min==0){
                memo[max] = 2;
            }
            else {
                memo[max] = 1;
            }
            for (int i=min;i<=high;i++){
                if (i-max<0){
                    memo[i] = memo[i-min];
                }
                else {
                    memo[i] = (memo[i-min]+memo[i-max])%1000000007;
                }
            }
            int sum = 0;
            for (int i=low;i<=high;i++){
                sum=(sum+memo[i])%1000000007;
            }
            return sum;
        }

        public int dp(HashMap<Integer, Integer> memo,int i, int low, int high){
            if (memo.get(i) != null){
                return memo.get(i);
            }
            if (i<low){
                return 0;
            }
            memo.put(i, (dp(memo, i-low, low, high)+dp(memo, i-high, low, high))%1000000007);
            return memo.get(i);
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.countGoodStrings(3, 3, 1, 1));
        }
    }
}
