package org.example;

public class SumInMatrix_6367 {
    static class Solution {
        public int matrixSum(int[][] nums) {
            int result = 0;
            int max;
            for (int i=0;i<nums.length;i++){
                max = 0;
                for (int j=0;j<nums.length;j++){
                        int localMax = 0;
                        int localIdx = 0;
                        for (int k=0;k<nums[j].length;k++){
                            if (nums[j][k]>localMax){
                                localMax = nums[j][k];
                                localIdx = k;
                            }
                        }
                        nums[j][localIdx] = 0;
                        if (localMax>max){
                            max = localMax;
                        }
                }
                result += max;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.matrixSum(new int[][]{{7, 2, 1,1,1}, {1, 1, 1,7,7}, {6, 5, 3,1,1},{7,6,1,1,1},{7,1,1,6,1}}));
        System.out.println(s.matrixSum(new int[][]{{1}}));
    }
}
