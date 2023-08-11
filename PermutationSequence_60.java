package org.example;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
    static class Solution {
        public String getPermutation(int n, int k) {
            StringBuilder result = new StringBuilder();
            List<Integer> arr = new ArrayList();
            for (int i=1;i<n+1;i++){
                arr.add(i);
            }
            int[] fact = new int[n];
            fact[0] = 1;
            for (int i=1;i<n;i++){
                fact[i] = fact[i-1]*(i+1);
            }
            int ind;
            k--;
            for (int i=0;i<n-1;i++){
                ind = k/fact[n-2-i];
                k = k%fact[n-2-i];
                int d = arr.remove(ind);
                result.append(d);
                if (k==0){
                    break;
                }
            }
            while (arr.size()>0){
                int last = arr.remove(0);
                result.append(last);
            }

            return result.toString();

        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.getPermutation(1, 1));
        }
    }}
