package org.example;

public class BrainPower_2140 {
    static class Solution {
        public long mostPoints(int[][] questions) {
            int[] memo = new int[questions.length];
            memo[questions.length-1] = questions[questions.length-1][0];
            for (int i=questions.length-2;i>=0;i--){
                int score = questions[i][0];
                int cost = questions[i][1];

                if (i+cost+1< questions.length){
                    memo[i] = Math.max(memo[i+cost+1]+score,memo[i+1]);
                }
                else {
                    memo[i] = Math.max(score,memo[i+1]);
                }
            }
            return memo[0];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
        System.out.println(s.mostPoints(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}));
        System.out.println(s.mostPoints(new int[][]{{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},{1,1},}));
    }
}
