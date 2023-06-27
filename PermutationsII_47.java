package org.example;

import java.security.PublicKey;
import java.util.*;

public class PermutationsII_47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int[] visited = new int[nums.length];
            HashSet<Integer> hashSet = new HashSet<>();
            List<List<Integer>> result = new LinkedList<>();
            for (int i=0;i<nums.length;i++){
                if (visited[i]==0 && !hashSet.contains(nums[i])){
                    visited[i]=1;
                    hashSet.add(nums[i]);
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    dfs(nums, visited, result, temp);
                    visited[i]=0;
                }
            }
            return result;
        }

        public void dfs(int[] nums, int[] visited, List<List<Integer>> result, List<Integer> cur){
            if (cur.size() == nums.length){
                List<Integer> finalT = new LinkedList<>(cur);
                result.add(finalT);
                return;
            }
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i=0;i<nums.length;i++){
                if (!hashSet.contains(nums[i]) && visited[i] == 0){
                    visited[i] = 1;
                    hashSet.add(nums[i]);
                    cur.add(nums[i]);
                    System.out.println(cur);
                    dfs(nums, visited, result, cur);
                    visited[i] = 0;
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}
