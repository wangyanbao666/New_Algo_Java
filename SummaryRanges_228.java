package org.example;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            boolean start = true;
            int s = nums[0];
            for (int i=1;i<nums.length;i++){
                if (nums[i] != nums[i-1]+1){
                    if (s==nums[i-1]){
                        result.add(String.valueOf(nums[i-1]));
                    }
                    else {
                        result.add(s+"->"+nums[i-1]);
                    }
                    s = nums[i];
                }
            }
            if (s==nums[nums.length-1]){
                result.add(String.valueOf(nums[nums.length-1]));
            }
            else {
                result.add(s+"->"+nums[nums.length-1]);
            }
            return result;
        }
    }
}
