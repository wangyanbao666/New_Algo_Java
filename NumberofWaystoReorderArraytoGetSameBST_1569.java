package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofWaystoReorderArraytoGetSameBST_1569 {
    class Solution {
        private long mod = (long)1e9 + 7;
        private long[][] table;
        public int numOfWays(int[] nums) {
            table = new long[1001][1001];
            for (int i=0;i<1001;i++){
                table[i][0]=1;
                table[i][i]=1;
            }
            for (int i=2;i<1001;i++){
                for (int j=1;j<i;j++){
                    table[i][j]=(table[i-1][j]+table[i-1][j-1])%mod;
                }
            }
            return (int)(((dfs(Arrays.stream(nums).boxed().toList()))-1)%mod);
        }
        public long dfs(List<Integer> nums){
            if (nums.size()<3){
                return 1;
            }
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();
            int root = nums.get(0);
            for (int i=1;i<nums.size();i++){
                if (nums.get(i)<root){
                    left.add(nums.get(i));
                }
                else {
                    right.add(nums.get(i));
                }
            }
            long leftResult = (dfs(left)%mod);
            long rightResult = (dfs(right)%mod);
            return (table[nums.size()-1][left.size()]*((leftResult*rightResult)%mod))%mod;
        }
    }
}
