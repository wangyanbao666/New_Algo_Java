package org.example;

import java.util.Arrays;

public class RestoreTheArray_1416 {
    class Solution {
        public int numberOfArrays(String s, int k) {
            int[] memo = new int[s.length()+1];
            Arrays.fill(memo, -1);
            memo[s.length()] = 1;
            return dfs(s, k, memo, 0);
        }

        public int dfs(String s, int k, int[] memo, int j){
            if (memo[j] != -1){
                return memo[j];
            }

            int result = 0;
            for (int i=j;i<s.length();i++){
                String prefix = s.substring(j, i+1);
                if (prefix.length()>10 || (prefix.length()==10 && prefix.charAt(0)!=1) || Integer.parseInt(prefix)>k){
                    break;
                }
                if (i+1==s.length() || s.charAt(i+1)!='0'){
                    int child = dfs(s,k,memo,i+1);
                    result += child;
                }
            }
            return result;
        }
    }
}
