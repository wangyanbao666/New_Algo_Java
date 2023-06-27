package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MakeArrayStrictlyIncreasing_1187 {
    class Solution {
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            Arrays.sort(arr2);
//            hashmap: k: idx in arr2, v: operation counts
            HashMap<Integer, Integer>[] memo = new HashMap[arr1.length];
            memo[0] = new HashMap<>();
            memo[0].put(-1, 0);
            if (arr2[0] < arr1[0]){
                memo[0].put(0, 1);
            }

            for (int i=1;i<arr1.length;i++){
//                update memo i
                memo[i] = new HashMap<>();

                HashMap<Integer, Integer> m = memo[i-1];
                Set<Map.Entry<Integer, Integer>> entrySet = m.entrySet();
                boolean flag=false;
                for (Map.Entry<Integer, Integer> entry: entrySet){

                    if (arr1[i]>arr1[i-1]){
                        memo[i].put(entry.getKey(), entry.getValue());
                        flag=true;
                    }
                    int val;
                    if (entry.getKey()==-1){
                        val=arr1[i];
                    }
                    else {
                        val=arr2[entry.getKey()];
                    }
                    int idx = binarySearch(arr2, val);
                    if (idx!=arr2.length){
                        if (entry.getValue()+1<memo[i].get(idx)){
                            memo[i].put(idx, entry.getValue()+1);
                        }
                        flag=true;
                    }
                    if (!flag){
                        return -1;
                    }

                }

            }

            HashMap<Integer, Integer> last = memo[arr1.length-1];
            Set<Map.Entry<Integer, Integer>> set = last.entrySet();
            int result=Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry: set){
                if (entry.getValue()<result){
                    result= entry.getValue();
                }
            }
            return result;

        }

        public int binarySearch(int[] arr2, int val){
            int l=0;
            int r=arr2.length;
            while (l<r){
                int n = l + (l+r)/2;
                if (arr2[n]<val && (n+1 == arr2.length || arr2[n+1]>=val)){
                    return n;
                }
                if (arr2[n]<=val){
                    l=n+1;
                }
                else {
                    r=n;
                }
            }
            return l;
        }
    }
}
