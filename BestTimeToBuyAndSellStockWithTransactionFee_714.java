package org.example;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int[][] profits = new int[prices.length][2];
            profits[0][0] = -prices[0];
            for (int i=1;i<prices.length;i++){
                profits[i][0] = Math.max(profits[i-1][0],profits[i-1][1]-prices[i]);
                profits[i][1] = Math.max(profits[i-1][1],profits[i-1][0]-fee+prices[i]);
            }
            return profits[prices.length-1][1];
        }
    }
}
