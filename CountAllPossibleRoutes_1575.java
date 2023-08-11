package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAllPossibleRoutes_1575 {
    class Solution {
        private int mod = 1000000007;
        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            int[][] memo = new int[fuel+1][locations.length];
            memo[0][start] = 1;
            for (int i=0;i<=fuel;i++){
                for (int j=0;j<locations.length;j++){
                    if (memo[i][j]!=0){
                        for (int k=0;k<locations.length;k++){
                            if (j!=k){
                                int cost = Math.abs(locations[j]-locations[k]);
                                if (cost<=fuel-i){
                                    memo[i+cost][k] = (memo[i][j]+memo[i+cost][k])%mod;
                                }
                            }
                        }
                    }
                }
            }
//            for (int[] ints : memo) {
//                System.out.println(Arrays.toString(ints));
//            }
            int result = 0;
            for (int i=0;i<=fuel;i++){
                result = (result + memo[i][finish])%mod;
            }
            return result;
        }
    }
}
