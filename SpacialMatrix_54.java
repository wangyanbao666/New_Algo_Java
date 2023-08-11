package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpacialMatrix_54 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List result = new ArrayList();
            double m = matrix.length;
            double n = matrix[0].length;
            for (int k=0;k<Math.min(Math.ceil(m/2),Math.ceil(n/2));k++){
                int i=k;
                int j=k;
                boolean flag = false;
                while (j<n-k){
                    flag = true;
                    result.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                if (!flag){
                    break;
                }
                flag = false;
                while (i<m-k){
                    flag = true;
                    result.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                if (!flag){
                    break;
                }
                flag = false;
                while (j>=k){
                    flag = true;
                    result.add(matrix[i][j]);
                    j--;
                }
                j++;
                i--;
                if (!flag){
                    break;
                }
                flag = false;
                while (i>=k+1){
                    flag = true;
                    result.add(matrix[i][j]);
                    i--;
                }
                if (!flag){
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
