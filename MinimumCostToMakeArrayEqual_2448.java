package org.example;

import java.util.*;

public class MinimumCostToMakeArrayEqual_2448 {

    static class Solution {
        class Pair {
            int num;
            int cost;
            Pair(int num, int cost){
                this.num = num;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "num=" + num +
                        ", cost=" + cost +
                        '}';
            }
        }
        public long minCost(int[] nums, int[] cost) {
            long numOfNums = 0;
            List<Pair> pairs = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                pairs.add(new Pair(nums[i], cost[i]));
                numOfNums += cost[i];
            }
            pairs.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.num == o2.num) {
                        return 0;
                    }
                    return o1.num > o2.num ? 1 : -1;
                }
            });
            if (numOfNums % 2==0){
                long num1 = numOfNums/2;
                long num2 = numOfNums/2+1;
                long cur =0;
                int a = 0;
                int b = 0;
                for (int i=0;i<pairs.size();i++){
                    cur+=pairs.get(i).cost;
                    if (a==0 && cur>=num1){
                        a=pairs.get(i).num;
                    }
                    if (cur>=num2){
                        b=pairs.get(i).num;
                        return calculateCost(nums, cost, (a+b)/2);
                    }
                }
            }
            else {
                long num1 = numOfNums/2+1;
                long cur =0;
                int a;
                for (int i=0;i<pairs.size();i++){
                    cur+=pairs.get(i).cost;
                    if (cur>=num1){
                        a=nums[i];
                        return calculateCost(nums, cost, a);
                    }
                }
            }
            return numOfNums;
        }

        public long calculateCost(int[] nums, int[] cost, int possible){
            long c = 0;
            for (int i=0;i<nums.length;i++){
                c+= (long) cost[i] * Math.abs(nums[i]-possible);
            }
            System.out.println(c);
            return c;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCost(new int[]{1,3,5,2,23,3,2,33}, new int[]{2,3,1,14,10,23,2,1});
//        solution.calculateCost(new int[]{1,3,5,2,23,3,2,33}, new int[]{2,3,1,14,10,23,2,1}, 3);
    }
}
