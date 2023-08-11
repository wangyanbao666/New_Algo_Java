package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathInZigZagBinaryTree_1104 {
    static class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> result = new LinkedList<>();
            int num = (int) (Math.log(label)/Math.log(2));
            int y;
            result.add(label);
            for (int i=0;i<num;i++){
                y = (int) (Math.log(label)/Math.log(2));
                int offset = (1<<(y+1))-label-1;
                int truePos = offset + (1<<y);
                label = truePos/2;
                result.add(label);
            }
            Collections.reverse(result);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pathInZigZagTree(13));
    }
}
