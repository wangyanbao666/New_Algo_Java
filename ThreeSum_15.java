package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                if (i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                int l = i+1;
                int r = nums.length-1;
                while (l<r){
                    int cur = nums[l]+nums[r]+nums[i];
                    if (cur>0){
                        r--;
                    } else if (cur<0) {
                        l++;
                    }
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[i]);
                        list.add(nums[r]);
                        result.add(list);
                        l++;
                        r--;
                    }
                    while (l>i+1 && l<=nums.length-1 && nums[l]==nums[l-1]){
                        l++;
                    }
                    while (r< nums.length-1 && r>=0 && nums[r]==nums[r+1]){
                        r--;
                    }
                }
            }
            return result;
        }
    }
}
