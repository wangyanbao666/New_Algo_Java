package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumLevelSumofABinaryTree_1161 {
//    class Solution {
//        public int maxLevelSum(TreeNode root) {
//            ArrayList<TreeNode> queue = new ArrayList<>();
//            queue.add(root);
//            int result = 0;
//            int index = 0;
//            int count = 1;
//            while (queue.size()>0){
//                ArrayList<TreeNode> newQueue = new ArrayList<>();
//                int temp = 0;
//                for (TreeNode node: queue){
//                    if (node.left!=null){
//                        newQueue.add(node.left);
//                    }
//                    if (node.right!=null){
//                        newQueue.add(node.right);
//                    }
//                    temp+=node.val;
//                }
//                if (temp>result){
//                    result = temp;
//                    index = count;
//                }
//                queue = newQueue;
//                count++;
//            }
//            return index;
//        }
//    }
    class Solution {
        public int maxLevelSum(TreeNode root) {
            int[] levels = new int[10001];
            int count = 0;
            int max = Integer.MIN_VALUE;
            int temp;
            int level = 1;
            int maxLevel = visit(1, root, levels);

            while (level<=maxLevel){
                temp = levels[level];
                if (max<temp){
                    max = temp;
                    count = level;
                }
                level++;
            }
            return count;
        }

        public int visit(int level, TreeNode node, int[] levels){
            if (node == null){
                return level-1;
            }
            levels[level] += node.val;
            int left = visit(level+1, node.left, levels);
            int right = visit(level+1, node.right, levels);
            return Math.max(left, right);
        }
    }
}
