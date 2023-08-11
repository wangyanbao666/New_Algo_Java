package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum_18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new LinkedList<>();
            for (int i=0;i<nums.length;i++){
                if (i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                List<List<Integer>> partial = threeSum(nums, target-nums[i], i);
                for (List<Integer> sub: partial){
                    sub.add(nums[i]);
                }
                result.addAll(partial);
            }
            return result;
        }

        public List<List<Integer>> threeSum(int[] nums, int target, int idx) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i=idx+1;i<nums.length;i++){
                if ((i>0 && nums[i] == nums[i-1]) || idx==i){
                    continue;
                }
                int l = i+1;
                int r = nums.length-1;
                while (l<r){
                    int cur = nums[l]+nums[r]+nums[i];
                    if (cur>target || r==idx){
                        r--;
                    } else if (cur<target || l==idx) {
                        l++;
                    }
                    else {
                        List<Integer> list = new LinkedList<>();
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
